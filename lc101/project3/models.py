from app import db
from hashutils import make_pw_hash
from datetime import datetime

class Menu(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120))
    price = db.Column(db.DECIMAL(10,2)) 
    inventory = db.Column(db.Integer)

    def __init__(self, name, price, inventory):
        self.name = name
        self.price = price
        self.inventory = inventory

class Cart(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120))
    amount = db.Column(db.Integer)
    total_price = db.Column(db.DECIMAL(10,2)) 
    owner_id = db.Column(db.Integer, db.ForeignKey('user.id'))

    def __init__(self, name, amount, total_price, owner):
        self.name = name
        self.amount = amount
        self.total_price = total_price
        self.owner = owner

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(120))
    pw_hash = db.Column(db.String(120))
    birthday = db.Column(db.DateTime)
    cart = db.relationship('Cart', backref='owner')

    def __init__(self, username, password, birthday):
        self.username = username
        self.pw_hash = make_pw_hash(password)
        if birthday is None:
            birthday = datetime.utcnow()
        self.birthday = birthday