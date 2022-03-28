import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
    constructor(props) {
        super(props);

        this.state = {
            users: []
        };
    }

    async componentDidMount() {
        fetch(
            "/user")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    users: json.content
                });
            })
    }

    render() {
        const {users} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>Users</h2>
                        {users.map(user =>
                            <div key={user.id}>
                                {user.firstName} {user.lastName}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
