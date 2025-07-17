import Header from './Header';
import Footer from './Footer';
import { Outlet } from 'react-router-dom'; 

function App() {
  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />

      <main className="flex-grow-1 container py-4">
        <Outlet /> 
      </main>

      <Footer />
    </div>
  );
}

export default App;
