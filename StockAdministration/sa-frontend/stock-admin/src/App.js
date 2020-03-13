import React from 'react';
import './App.css';
import { AuthenticationFormComponent } from "./authentication/AuthenticationForm";
import { HeaderComponent } from "./commons/Header"
import { FooterComponent } from "./commons/Footer"

class ContentComponent extends React.Component{
  render() {
    return(
      <div>
        ContentComponent
      </div>
    );
  }
}

class App extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      authenticated : false
    }
  };

  handleSubmit(e) {
    const uname = document.getElementById('username').value;
    const pword = document.getElementById('password').value;

    fetch(process.env.REACT_APP_AUTH_URL,{
      method: 'post',
      mode: 'cors',
      headers: {
        'Content-type' : "application/x-www-form-urlencoded; charset=UTF-8"
      },
      body: JSON.stringify({u: uname, p: pword})
    })
    .then(function (data){
      console.log('Request succeeded with JSON response', data);
      // if(data.)
      // this.setstate({
      //   authenticated:true
      // });
    })
    .catch(function (error) {
      console.log('Request failed', error);
    });
  }

  render() {
    const isAuthenticated = this.state.authenticated;
    let contents;
    if(isAuthenticated){
      contents = <ContentComponent/>
    } else {
      contents = <AuthenticationFormComponent 
        authenticated={isAuthenticated} 
        onSubmit={() => this.handleSubmit()}/>
    }
    return (
      <div className="container">
        <HeaderComponent/>
        {contents}
        <FooterComponent/>
      </div>
    );
  }
}

export default App;
