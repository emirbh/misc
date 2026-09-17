package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.PricingStructureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An abstract pricing structure base type. Used as a base for structures such as yield curves and volatility matrices.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract pricing structure base type. Used as a base for structures such as yield curves and volatility matrices.
 *
 */
@RosettaDataType(value="PricingStructure", builder=PricingStructure.PricingStructureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingStructure", model="fpml", builder=PricingStructure.PricingStructureBuilderImpl.class, version="2.1.1")
public interface PricingStructure extends RosettaModelObject {

	PricingStructureMeta metaData = new PricingStructureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of the structure, e.g "USDLIBOR-3M EOD Curve".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the structure, e.g "USDLIBOR-3M EOD Curve".
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency that the structure is expressed in (this is relevant mostly for the Interes Rates asset class).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency that the structure is expressed in (this is relevant mostly for the Interes Rates asset class).
	 *
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	PricingStructure build();
	
	PricingStructure.PricingStructureBuilder toBuilder();
	
	static PricingStructure.PricingStructureBuilder builder() {
		return new PricingStructure.PricingStructureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructure> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingStructure> getType() {
		return PricingStructure.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructureBuilder extends PricingStructure, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		PricingStructure.PricingStructureBuilder setId(String id);
		PricingStructure.PricingStructureBuilder setName(String name);
		PricingStructure.PricingStructureBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		PricingStructure.PricingStructureBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructure  ***********************/
	class PricingStructureImpl implements PricingStructure {
		private final String id;
		private final String name;
		private final Currency currency;
		
		protected PricingStructureImpl(PricingStructure.PricingStructureBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public PricingStructure build() {
			return this;
		}
		
		@Override
		public PricingStructure.PricingStructureBuilder toBuilder() {
			PricingStructure.PricingStructureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructure.PricingStructureBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructure _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructure {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingStructure  ***********************/
	class PricingStructureBuilderImpl implements PricingStructure.PricingStructureBuilder {
	
		protected String id;
		protected String name;
		protected Currency.CurrencyBuilder currency;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PricingStructure.PricingStructureBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public PricingStructure.PricingStructureBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public PricingStructure.PricingStructureBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public PricingStructure build() {
			return new PricingStructure.PricingStructureImpl(this);
		}
		
		@Override
		public PricingStructure.PricingStructureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructure.PricingStructureBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructure.PricingStructureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingStructure.PricingStructureBuilder o = (PricingStructure.PricingStructureBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructure _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
