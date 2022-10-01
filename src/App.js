import logo from './logo.svg';
import './App.css';
import { GetData } from './home/GetData';
import { PostForm } from './home/PostForm';
import { Header } from './home/Header';
import { Index } from './home/Index';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
function App() {
  return (
      <>
      <Header/>
       <Router>
      <Routes>
        <Route exact path="/" element={<PostForm/>}> </Route>
        <Route path="/getdata" element={<GetData/>}></Route>
        <Route path='/index' element={<Index/>}></Route>
        </Routes> 
        </Router>
         
        </>
   
  );
}

export default App;
