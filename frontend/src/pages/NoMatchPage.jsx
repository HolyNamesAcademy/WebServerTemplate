import { Link } from 'react-router-dom';

// This page renders when an error occurs when trying to find a page.
// It might not show up much, but you can style it bellow
function NoMatchPage() {
  return (
    <div>
      <h2>Nothing to see here!</h2>
      <p>
        <Link to="/">Go to the home page</Link>
      </p>
    </div>
  );
}

export default NoMatchPage;
