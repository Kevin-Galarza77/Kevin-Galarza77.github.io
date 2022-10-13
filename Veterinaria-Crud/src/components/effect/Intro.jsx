import React,{useEffect,useState} from 'react';

const Intro = () => 
{
  const [countOne, setcountOne] = useState (0);
  const [counttwo, setCounttwo] = useState(0);

  useEffect(() => {
 
    console.log("1.-Use efect sin dependencias");


  });
  useEffect(() => {

    console.log("2.-Use efect con arrray vacio []");


  },[]);
  useEffect(() => {

    console.log("3.-Use efect con dependencia");


  },[countOne]);


  return (
    <div>
      Counter One --{countOne}    
      <button className='btn btn-success' onClick={()=>{setcountOne(countOne+5)}}>Incrementar en 5</button>
    </div>
  )
}

export default Intro

