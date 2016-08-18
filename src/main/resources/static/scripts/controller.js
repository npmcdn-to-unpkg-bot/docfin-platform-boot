var CommentBox = React.createClass({
  loadCommentsFromServer: function() {
    $.ajax({
      url: this.props.url,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({data: data._embedded.countries});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
  },
  getInitialState: function() {
    return {data: []};
  },
  componentDidMount: function() {
    this.loadCommentsFromServer();
    setInterval(this.loadCommentsFromServer, this.props.pollInterval);
  },
  render: function() {
    return (
      <div className="commentBox">
        <h1>Whats up Doc?</h1>
        <h2>Here is a list of countries-</h2>
        <CommentList data={this.state.data} />
      </div>
    );
  }
});



var CommentList = React.createClass({
  render: function() {
    var countryNodes = this.props.data.map(function(country) {
      return (
        <Comment name={country.name} createdBy={country.createdBy}>
          {country.name}
        </Comment>
      );
    });
    return (
      <div className="commentList">
        {countryNodes}
      </div>
    );
  }
});

var Comment = React.createClass({
  rawMarkup: function() {
    var md = new Remarkable();
    var rawMarkup = md.render(this.props.children.toString());
    return { __html: rawMarkup };
  },

  render: function() {
    return (
      <div className="comment">
        <h3 className="country">
          CreatedBy: {this.props.createdBy}
        </h3>
        <span dangerouslySetInnerHTML={this.rawMarkup()} />
      </div>
    );
  }
});

ReactDOM.render(
  <CommentBox url="/countries" pollInterval={2000} />,
  document.getElementById('content')
);