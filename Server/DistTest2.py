from flask import Flask, request, jsonify
import mysql.connector
import sys
import json
from pymongo import MongoClient
from bson.json_util import dumps, loads
from json import JSONEncoder

class EmployeeEncoder(JSONEncoder):
    def default(self, o):
        return o.__dict__

app = Flask(__name__)

@app.route('/cpu', methods = ['GET'])
def selectCPU():
    select_query = "SELECT * FROM cpu"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}

    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        #content = {'index_cpu':result[0], 'manufacturer':result[1], \
            #'name':result[2], 'price':result[3], 'socket':result[4], 'core':result[5], \
            #'thread':result[6], 'clock':result[7], 'graphic':result[8]}
        
        content = {'index_cpu':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'socket':temp[4], 'core':temp[5], \
            'thread':temp[6], 'clock':temp[7], 'graphic':temp[8]}        
        
        payload.append(content)
        content = {}

    data['result'] = payload

    print(data)
    print(type(data))

    return json.dumps(data)
    #return jsonify(data)

@app.route('/cpu', methods = ['POST'])
def selectCPU_name():
    select_query = "SELECT * FROM cpu WHERE name = \"" + request.form['name'] + "\""

    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_cpu':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'socket':temp[4], 'core':temp[5], \
            'thread':temp[6], 'clock':temp[7], 'graphic':temp[8]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)

    #return jsonify(data)

@app.route('/mb', methods = ['GET'])
def selectMB():
    select_query = "SELECT * FROM mainboard"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])
        
        content = {'index_mainboard':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'standard':temp[4], 'socket':temp[5], \
            'chipset':temp[6]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)

    #return jsonify(data)

@app.route('/mb', methods = ['POST'])
def selectMB_name():
    select_query = "SELECT * FROM mainboard WHERE name = \"" + request.form['name'] + "\""

    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_mainboard':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'standard':temp[4], 'socket':temp[5], \
            'chipset':temp[6]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/cooler', methods = ['GET'])
def selectCooler():
    select_query = "SELECT * FROM cooler"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_cooler':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'height':temp[4], 'method':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/cooler', methods = ['POST'])
def selectCooler_name():
    select_query = "SELECT * FROM cooler WHERE name = \"" + request.form['name'] + "\""
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])
        
        content = {'index_cooler':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'height':temp[4], 'method':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)
    
@app.route('/case', methods = ['GET'])
def selectCase():
    select_query = "SELECT * FROM android.case"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_case':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'size':temp[4], 'standard':temp[5], \
            'cooler_size':temp[6], 'vga_size':temp[7], 'radiator_size':temp[8]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/case', methods = ['POST'])
def selectCase_name():
    select_query = "SELECT * FROM android.case WHERE name = \"" + request.form['name'] + "\""
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_case':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'size':temp[4], 'standard':temp[5], \
            'cooler_size':temp[6], 'vga_size':temp[7], 'radiator_size':temp[8]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/power', methods = ['GET'])
def selectPower():
    select_query = "SELECT * FROM power"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_power':temp[0], 'powercol':temp[1], \
            'manufacturer':temp[2], 'name':temp[3], 'price':temp[4], 'power':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/power', methods = ['POST'])
def selectPower_name():
    select_query = "SELECT * FROM power WHERE name = \"" + request.form['name'] + "\""
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_power':temp[0], 'powercol':temp[1], \
            'manufacturer':temp[2], 'name':temp[3], 'price':temp[4], 'power':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/vga', methods = ['GET'])
def selectVga():
    select_query = "SELECT * FROM vga"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_vga':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'chipset':temp[4], 'gddr':temp[5], \
            'length':temp[6], 'power':temp[7]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/vga', methods = ['POST'])
def selectVga_name():
    select_query = "SELECT * FROM vga WHERE name = \"" + request.form['name'] + "\""
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_vga':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'chipset':temp[4], 'gddr':temp[5], \
            'length':temp[6], 'power':temp[7]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/ram', methods = ['GET'])
def selectRam():
    select_query = "SELECT * FROM ram"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_ram':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'capacity':temp[4], 'clock':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/ram', methods = ['POST'])
def selectRam_name():
    select_query = "SELECT * FROM ram WHERE name = \"" + request.form['name'] + "\""
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_ram':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'capacity':temp[4], 'clock':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/storage', methods = ['GET'])
def selectStorage():
    select_query = "SELECT * FROM storage"
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_storage':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'type':temp[4], 'capacity':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/storage', methods = ['POST'])
def selectStorage_name():
    select_query = "SELECT * FROM storage WHERE name = \"" + request.form['name'] + "\""
    
    db_cursor.execute(select_query)
    records = db_cursor.fetchall()

    payload = []
    content = {}
    data = {}
    for result in records:
        temp = []
        for i in range(len(result)):
            if isinstance(result[i], bytearray):
               print("true") 
               temp.append(result[i].decode())
            else:
               temp.append(result[i])

        content = {'index_storage':temp[0], 'manufacturer':temp[1], \
            'name':temp[2], 'price':temp[3], 'type':temp[4], 'capacity':temp[5]}
        payload.append(content)
        content = {}

    data['result'] = payload

    return json.dumps(data)
    #return jsonify(data)

@app.route('/user_list', methods = ['POST'])
def userList():
    data = request.get_json()
    
    token = data["user_token"]

    query = {"user_token":token}

    client = MongoClient("mongodb://localhost:27017/")
    db = client["danawa"]
    collection = db["userList"]
    
    results = collection.find_one(query)

    if results == None:
        collection.insert_one(data)
    else:
        collection.remove(query)
        collection.insert_one(data)
        
    return "Success"

@app.route('/user_list_get', methods = ['POST'])
def userList_get():
    token = request.form['token']

    query = {"user_token":token}

    client = MongoClient("mongodb://localhost:27017/")
    db = client["danawa"]
    collection = db["userList"]
    
    results = collection.find_one(query, {"_id":0})

    print(results)

    if results == None:
        return "Failed"
    else:
        return json.dumps(results)
        #return jsonify(results)

try:
    chat_db = mysql.connector.connect(host="", \
        user="", passwd="", database="", charset="")
except:
    sys.exit("Error connecting to the database. Please check your inputs.")

db_cursor = chat_db.cursor()

app.run(host="0.0.0.0", port=5000)
#app.run(host="0.0.0.0", port=5000, debug=True, threaded=True) # Run in development server.
# waitress.serve(app=app, host="0.0.0.0", port=5000) # Run in production server.
