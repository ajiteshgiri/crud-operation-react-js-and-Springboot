import axios from "axios";
import React, { useEffect } from "react";
import { useState } from "react";

export function GetData(){
  var [resData,setData]=useState([]);
    useEffect(() => {
        axios.get("http://localhost:8081/api/all")
          .then((response) =>{
            console.log(response.data);
           setData(response.data)
          })
          .catch((error)=>{
          
          })
        }, []);
    return(
        <div className="container-fluid">
          <div className="row">
          <div className="col-md-4"></div>
          <div className="col-md-4 tblform">
          <table className="table table-striped table-succes">
            <tr>
              <th>Name</th>
              <th>Email</th>
              <th>Address</th>
            </tr>
            {resData.map((e)=>
             <tr>
                <td>{e.name}</td>
                <td>{e.email}</td>
                <td>{e.address}</td>
             </tr>
            )}
           
          </table>
          </div>
          </div>
        </div>
    )
}
