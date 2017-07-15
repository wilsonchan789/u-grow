from flask import Flask, request, redirect, render_template, flash, session
import re
from app import app, db
from models import Menu, Cart, User
from hashutils import check_pw_hash
from date import validate

app.secret_key = 'b6d2d1c83bcc4d09985fa319e9837c4053d87a99673eab9c204e38f0b395b0b0,QmJne'

@app.route("/signup", methods=['GET', 'POST'])
def signup():
    if request.method == 'GET':
        return render_template('signup.html')
    username = request.form['username']
    password = request.form['password']
    verify = request.form['verify']
    birthday = request.form['birthday']
    username_error = ''
    password_error=''
    verify_error=''
    birthday_error=''
    existing_user = User.query.filter_by(username=username).first()
    # Check for any username, password, verify or existing user errors
    if re.search(r"\s+", username):
        username_error = "That's not a valid username"
    elif re.search(r"^.{0,2}$", username):
        username_error = "That username is too short"
    elif existing_user:
        username_error = "That username already exist"
    if username_error:
        flash(username_error, 'error')
    if re.search(r"\s+", password):
        password_error = "That's not a valid password"
    elif re.search(r"^.{0,2}$", password):
        password_error = "That password is too short"
    if password_error:
        flash(password_error, 'error')
    if verify != password:
        verify_error = "Passwords don't match"
        flash(verify_error, 'error')
    if validate(birthday):
        birthday_error = validate(birthday)
        flash(birthday_error, 'error')
    # If there is no errors than login and add a session and add the info to a database
    if not existing_user and not username_error and not password_error and not verify_error and not birthday_error:
        new_user = User(username, password, birthday)
        db.session.add(new_user)
        db.session.commit()
        session['username'] = new_user.username
        flash("Logged in!")
        return redirect('/newpost')
    else:
        return render_template('signup.html', username=username)

@app.route('/login', methods = ['POST', 'GET'])
def login():
    if request.method == 'GET':
        return render_template('login.html')
    # Check if the user and password are correct to login
    username = request.form['username']
    password = request.form['password']
    username_error = ''
    password_error = ''
    user = User.query.filter_by(username=username).first()
    if user and check_pw_hash(password, user.pw_hash):
        session['username'] = user.username
        flash("Logged in!")
        return redirect('/newpost')
    elif user and user.password != password:
        password_error = 'User password incorrect'
        flash(password_error, 'error')
    elif not user:
        username_error = 'User does not exist'
        flash(username_error, 'error')
    return render_template('login.html', username=username)