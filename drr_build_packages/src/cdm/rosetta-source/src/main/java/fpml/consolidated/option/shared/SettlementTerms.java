package fpml.consolidated.option.shared;

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
import fpml.consolidated.option.shared.meta.SettlementTermsMeta;
import fpml.consolidated.shared.Currency;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="SettlementTerms", builder=SettlementTerms.SettlementTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementTerms", model="fpml", builder=SettlementTerms.SettlementTermsBuilderImpl.class, version="2.1.1")
public interface SettlementTerms extends RosettaModelObject {

	SettlementTermsMeta metaData = new SettlementTermsMeta();

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
	 * Provision ISDA 2003 Term: Settlement Currency
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA 2003 Term: Settlement Currency
	 *
	 */
	Currency getSettlementCurrency();

	/*********************** Build Methods  ***********************/
	SettlementTerms build();
	
	SettlementTerms.SettlementTermsBuilder toBuilder();
	
	static SettlementTerms.SettlementTermsBuilder builder() {
		return new SettlementTerms.SettlementTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementTerms> getType() {
		return SettlementTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementTermsBuilder extends SettlementTerms, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		SettlementTerms.SettlementTermsBuilder setId(String id);
		SettlementTerms.SettlementTermsBuilder setSettlementCurrency(Currency settlementCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
		}
		

		SettlementTerms.SettlementTermsBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementTerms  ***********************/
	class SettlementTermsImpl implements SettlementTerms {
		private final String id;
		private final Currency settlementCurrency;
		
		protected SettlementTermsImpl(SettlementTerms.SettlementTermsBuilder builder) {
			this.id = builder.getId();
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public SettlementTerms build() {
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			SettlementTerms.SettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementTerms.SettlementTermsBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTerms {" +
				"id=" + this.id + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementTerms  ***********************/
	class SettlementTermsBuilderImpl implements SettlementTerms.SettlementTermsBuilder {
	
		protected String id;
		protected Currency.CurrencyBuilder settlementCurrency;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SettlementTerms.SettlementTermsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@Override
		public SettlementTerms build() {
			return new SettlementTerms.SettlementTermsImpl(this);
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementTerms.SettlementTermsBuilder o = (SettlementTerms.SettlementTermsBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTermsBuilder {" +
				"id=" + this.id + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}';
		}
	}
}
