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
		this.state = {questions: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/questions'}).done(response => {
			this.setState({questions: response.entity._embedded.questions});
		});
	}

	render() {
		return (
			<QuestionList questions={this.state.questions}/>
		)
	}
}
// end::app[]

// tag::question-list[]
class QuestionList extends React.Component{
	render() {
        var questions = this.props.questions.map(question =>
			<Question key={question._links.self.href} question={question}/>
        );
		return (
			<b>
				{questions}
			</b>
		)
	}
}
// end::question-list[]

// tag::question[]
class Question extends React.Component{
    constructor(props) {
        super(props);
        this.state = {celectCases: []};
    }

    componentDidMount() {
        client({method: 'GET', path: this.question.celectCases.href}).done(response => {
            this.setState({celectCases: response.entity._embedded.celectCases});
        });
    }

	render() {
		return (
			<table>
				<tr>
					<th>{this.props.question.info}</th>
				</tr>
				<CelectList celectCases={this.state.celectCases} question={this.props.question}/>
			</table>
		)
	}
}

class CelectList extends React.Component{
	render() {
        var cases = this.props.celectCases.map(celectCase =>
			<CelectCase key={celectCase._links.celectCase.href} celectCase={celectCase}/>
        );
		return (
			<p>
			{cases}
			</p>
		)
	}
}
// end::question[]

class CelectCase extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.celectCase.mainInfo}</td>
				<td>{this.props.celectCase.fullInfo}</td>
			</tr>
		)
	}
}

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
);
// end::render[]

