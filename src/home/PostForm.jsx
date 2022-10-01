import axios, { Axios } from "axios";
import React from "react";
import { useState } from "react";
export function PostForm(){
   const[name,setName] = useState("");
   const[email,setEmail] = useState("");
   const[address,setAddress] = useState("");

   function saveUser(){
    let data={name,email,address}
    console.warn(name,email,address);
    fetch("http://localhost:8081/api/save",{
        method:'Post',
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        body:JSON.stringify(data)
    }).then((result)=>{
        console.warn("result",result)
    })
   }
   return(
        <div className="container">
            <div className="row"> 
            <div className="col-md-6">
                <h2>Post Api call</h2>
                <input type="text" value={name} onChange={(e)=>{setName(e.target.value)}} name="name" className="form-control input" placeholder="Enter your Name"/>
                <input type="email" value={email} onChange={(e)=>{setEmail(e.target.value)}} name="email" className="form-control input" placeholder="Enter Your email"/>
                <input type="address" value={address} onChange={(e)=>{setAddress(e.target.value)}} name="address" className="form-control input" placeholder="Enter Your address" />
                <button type ="button" className="btn btn-primary" onClick={saveUser}>Save new user</button>
            </div>
            </div>
        </div>
   );
       
}