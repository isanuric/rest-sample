import React, { Component } from "react";
import { Button, FormGroup, FormControl, ControlLabel } from "react-bootstrap";
import "./style.css";

export default class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: ""
        };
    }

    validateForm() {
        return this.state.email.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
    this.setState({
        [event.target.id]: event.target.value
});
}

handleSubmit = event => {
    event.preventDefault();
}

render() {
    return (
        <div className="Login">
        <form onSubmit={this.handleSubmit}>
<FormGroup controlId="email" bsSize="large">
        <ControlLabel>Email</ControlLabel>
        <FormControl
    autoFocus
    type="email"
    value={this.state.email}
    onChange={this.handleChange}
    />
    </FormGroup>
    <FormGroup controlId="password" bsSize="large">
        <ControlLabel>Password</ControlLabel>
        <FormControl
    value={this.state.password}
    onChange={this.handleChange}
    type="password"
        />
        </FormGroup>
        <Button
    block
    bsSize="large"
    disabled={!this.validateForm()}
    type="submit"
        >
        Login
        </Button>
        </form>
        </div>
);
}
}


class Square extends React.Component {
    render() {
        return (
            <button className="square">
                {/* TODO */}
            </button>
        );
    }
}

class Board extends React.Component {
    renderSquare(i) {
        return <Square />;
    }

    render() {
        const status = 'Next player: X';

        return (
            <div>
                <div className="status">{status}</div>
                <div className="board-row">
                    {this.renderSquare(0)}
                    {this.renderSquare(1)}
                    {this.renderSquare(2)}
                </div>
                <div className="board-row">
                    {this.renderSquare(3)}
                    {this.renderSquare(4)}
                    {this.renderSquare(5)}
                </div>
                <div className="board-row">
                    {this.renderSquare(6)}
                    {this.renderSquare(7)}
                    {this.renderSquare(8)}
                </div>
            </div>
        );
    }
}

class Game extends React.Component {
    render() {
        return (
            <div className="game">
                <div className="game-board">
                    <Board />
                </div>
                <div className="game-info">
                    <div>{/* status */}</div>
                    <ol>{/* TODO */}</ol>
                </div>
            </div>
        );
    }
}

// ========================================

ReactDOM.render(
    <Game />,
    document.getElementById('root')
);


