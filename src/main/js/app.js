'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {celectcases: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/question/1/case'}).done(response => {
			this.setState({celectcases: response.entity._embedded.celectcases});
		});
	}

	render() {
		return (
			<CelectcaseList employees={this.state.celectcases}/>
		)
	}
}
// end::app[]

// tag::employee-list[]
class CelectcaseList extends React.Component{
	render() {
		var celectcases = this.props.celectcases.map(celectcase =>
			<Celectcase celectcase={celectcase}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>Main Info</th>
						<th>Full info</th>
					</tr>
					{celectcase}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::case[]
class Celectcase extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.celectcase.id}</td>
				<td>{this.props.celectcase.mainInfo}</td>
				<td>{this.props.celectcase.fullInfo}</td>
			</tr>
		)
	}
}
// end::case[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
);
// end::render[]

