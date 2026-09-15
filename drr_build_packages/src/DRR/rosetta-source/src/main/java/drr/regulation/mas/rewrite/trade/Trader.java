package drr.regulation.mas.rewrite.trade;

import cdm.base.staticdata.party.Address;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.regulation.mas.rewrite.trade.meta.TraderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="Trader", builder=Trader.TraderBuilderImpl.class, version="7.7.0")
@RuneDataType(value="Trader", model="drr", builder=Trader.TraderBuilderImpl.class, version="7.7.0")
public interface Trader extends RosettaModelObject {

	TraderMeta metaData = new TraderMeta();

	/*********************** Getter Methods  ***********************/
	String getName();
	Address getPlaceOfEmployment();
	Boolean getIsAuthorisedToTradeInSingapore();
	Address getCurrentLocation();

	/*********************** Build Methods  ***********************/
	Trader build();
	
	Trader.TraderBuilder toBuilder();
	
	static Trader.TraderBuilder builder() {
		return new Trader.TraderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Trader> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Trader> getType() {
		return Trader.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("placeOfEmployment"), processor, Address.class, getPlaceOfEmployment());
		processor.processBasic(path.newSubPath("isAuthorisedToTradeInSingapore"), Boolean.class, getIsAuthorisedToTradeInSingapore(), this);
		processRosetta(path.newSubPath("currentLocation"), processor, Address.class, getCurrentLocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TraderBuilder extends Trader, RosettaModelObjectBuilder {
		Address.AddressBuilder getOrCreatePlaceOfEmployment();
		@Override
		Address.AddressBuilder getPlaceOfEmployment();
		Address.AddressBuilder getOrCreateCurrentLocation();
		@Override
		Address.AddressBuilder getCurrentLocation();
		Trader.TraderBuilder setName(String name);
		Trader.TraderBuilder setPlaceOfEmployment(Address placeOfEmployment);
		Trader.TraderBuilder setIsAuthorisedToTradeInSingapore(Boolean isAuthorisedToTradeInSingapore);
		Trader.TraderBuilder setCurrentLocation(Address currentLocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("placeOfEmployment"), processor, Address.AddressBuilder.class, getPlaceOfEmployment());
			processor.processBasic(path.newSubPath("isAuthorisedToTradeInSingapore"), Boolean.class, getIsAuthorisedToTradeInSingapore(), this);
			processRosetta(path.newSubPath("currentLocation"), processor, Address.AddressBuilder.class, getCurrentLocation());
		}
		

		Trader.TraderBuilder prune();
	}

	/*********************** Immutable Implementation of Trader  ***********************/
	class TraderImpl implements Trader {
		private final String name;
		private final Address placeOfEmployment;
		private final Boolean isAuthorisedToTradeInSingapore;
		private final Address currentLocation;
		
		protected TraderImpl(Trader.TraderBuilder builder) {
			this.name = builder.getName();
			this.placeOfEmployment = ofNullable(builder.getPlaceOfEmployment()).map(f->f.build()).orElse(null);
			this.isAuthorisedToTradeInSingapore = builder.getIsAuthorisedToTradeInSingapore();
			this.currentLocation = ofNullable(builder.getCurrentLocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("placeOfEmployment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("placeOfEmployment")
		public Address getPlaceOfEmployment() {
			return placeOfEmployment;
		}
		
		@Override
		@RosettaAttribute("isAuthorisedToTradeInSingapore")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isAuthorisedToTradeInSingapore")
		public Boolean getIsAuthorisedToTradeInSingapore() {
			return isAuthorisedToTradeInSingapore;
		}
		
		@Override
		@RosettaAttribute("currentLocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentLocation")
		public Address getCurrentLocation() {
			return currentLocation;
		}
		
		@Override
		public Trader build() {
			return this;
		}
		
		@Override
		public Trader.TraderBuilder toBuilder() {
			Trader.TraderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trader.TraderBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getPlaceOfEmployment()).ifPresent(builder::setPlaceOfEmployment);
			ofNullable(getIsAuthorisedToTradeInSingapore()).ifPresent(builder::setIsAuthorisedToTradeInSingapore);
			ofNullable(getCurrentLocation()).ifPresent(builder::setCurrentLocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trader _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(placeOfEmployment, _that.getPlaceOfEmployment())) return false;
			if (!Objects.equals(isAuthorisedToTradeInSingapore, _that.getIsAuthorisedToTradeInSingapore())) return false;
			if (!Objects.equals(currentLocation, _that.getCurrentLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (placeOfEmployment != null ? placeOfEmployment.hashCode() : 0);
			_result = 31 * _result + (isAuthorisedToTradeInSingapore != null ? isAuthorisedToTradeInSingapore.hashCode() : 0);
			_result = 31 * _result + (currentLocation != null ? currentLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trader {" +
				"name=" + this.name + ", " +
				"placeOfEmployment=" + this.placeOfEmployment + ", " +
				"isAuthorisedToTradeInSingapore=" + this.isAuthorisedToTradeInSingapore + ", " +
				"currentLocation=" + this.currentLocation +
			'}';
		}
	}

	/*********************** Builder Implementation of Trader  ***********************/
	class TraderBuilderImpl implements Trader.TraderBuilder {
	
		protected String name;
		protected Address.AddressBuilder placeOfEmployment;
		protected Boolean isAuthorisedToTradeInSingapore;
		protected Address.AddressBuilder currentLocation;
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("placeOfEmployment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("placeOfEmployment")
		public Address.AddressBuilder getPlaceOfEmployment() {
			return placeOfEmployment;
		}
		
		@Override
		public Address.AddressBuilder getOrCreatePlaceOfEmployment() {
			Address.AddressBuilder result;
			if (placeOfEmployment!=null) {
				result = placeOfEmployment;
			}
			else {
				result = placeOfEmployment = Address.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isAuthorisedToTradeInSingapore")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isAuthorisedToTradeInSingapore")
		public Boolean getIsAuthorisedToTradeInSingapore() {
			return isAuthorisedToTradeInSingapore;
		}
		
		@Override
		@RosettaAttribute("currentLocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentLocation")
		public Address.AddressBuilder getCurrentLocation() {
			return currentLocation;
		}
		
		@Override
		public Address.AddressBuilder getOrCreateCurrentLocation() {
			Address.AddressBuilder result;
			if (currentLocation!=null) {
				result = currentLocation;
			}
			else {
				result = currentLocation = Address.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("name")
		@Override
		public Trader.TraderBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("placeOfEmployment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("placeOfEmployment")
		@Override
		public Trader.TraderBuilder setPlaceOfEmployment(Address _placeOfEmployment) {
			this.placeOfEmployment = _placeOfEmployment == null ? null : _placeOfEmployment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isAuthorisedToTradeInSingapore")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isAuthorisedToTradeInSingapore")
		@Override
		public Trader.TraderBuilder setIsAuthorisedToTradeInSingapore(Boolean _isAuthorisedToTradeInSingapore) {
			this.isAuthorisedToTradeInSingapore = _isAuthorisedToTradeInSingapore == null ? null : _isAuthorisedToTradeInSingapore;
			return this;
		}
		
		@RosettaAttribute("currentLocation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentLocation")
		@Override
		public Trader.TraderBuilder setCurrentLocation(Address _currentLocation) {
			this.currentLocation = _currentLocation == null ? null : _currentLocation.toBuilder();
			return this;
		}
		
		@Override
		public Trader build() {
			return new Trader.TraderImpl(this);
		}
		
		@Override
		public Trader.TraderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trader.TraderBuilder prune() {
			if (placeOfEmployment!=null && !placeOfEmployment.prune().hasData()) placeOfEmployment = null;
			if (currentLocation!=null && !currentLocation.prune().hasData()) currentLocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getPlaceOfEmployment()!=null && getPlaceOfEmployment().hasData()) return true;
			if (getIsAuthorisedToTradeInSingapore()!=null) return true;
			if (getCurrentLocation()!=null && getCurrentLocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trader.TraderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trader.TraderBuilder o = (Trader.TraderBuilder) other;
			
			merger.mergeRosetta(getPlaceOfEmployment(), o.getPlaceOfEmployment(), this::setPlaceOfEmployment);
			merger.mergeRosetta(getCurrentLocation(), o.getCurrentLocation(), this::setCurrentLocation);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getIsAuthorisedToTradeInSingapore(), o.getIsAuthorisedToTradeInSingapore(), this::setIsAuthorisedToTradeInSingapore);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trader _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(placeOfEmployment, _that.getPlaceOfEmployment())) return false;
			if (!Objects.equals(isAuthorisedToTradeInSingapore, _that.getIsAuthorisedToTradeInSingapore())) return false;
			if (!Objects.equals(currentLocation, _that.getCurrentLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (placeOfEmployment != null ? placeOfEmployment.hashCode() : 0);
			_result = 31 * _result + (isAuthorisedToTradeInSingapore != null ? isAuthorisedToTradeInSingapore.hashCode() : 0);
			_result = 31 * _result + (currentLocation != null ? currentLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TraderBuilder {" +
				"name=" + this.name + ", " +
				"placeOfEmployment=" + this.placeOfEmployment + ", " +
				"isAuthorisedToTradeInSingapore=" + this.isAuthorisedToTradeInSingapore + ", " +
				"currentLocation=" + this.currentLocation +
			'}';
		}
	}
}
