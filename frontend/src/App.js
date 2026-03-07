import React from 'react';
import CreateListing from './CreateListing';
import ViewListings from './ViewListings';

function App() {
  return (
    <div style={{ display: 'flex', justifyContent: 'space-around', padding: '40px' }}>
      {/* Left side: The form you built */}
      <div style={{ flex: 1 }}>
        <CreateListing />
      </div>

      {/* Right side: The new bulletin board */}
      <div style={{ flex: 1 }}>
        <ViewListings />
      </div>
    </div>
  );
}

export default App;


