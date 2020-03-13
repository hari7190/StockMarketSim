import React from 'react';
import './AuthenticationForm.css'
export class AuthenticationFormComponent extends React.Component{
    render(props) {
      return (
        <div>
            <form >
                <label> Username </label>
                <input id="username" type="text"/>
            
                <label> Password </label>
                <input id="password" type="password"/>

                <input type="button" value="Login" id="submit" onClick={this.props.onSubmit}/>
            </form>
        </div>
      );
    }
  }