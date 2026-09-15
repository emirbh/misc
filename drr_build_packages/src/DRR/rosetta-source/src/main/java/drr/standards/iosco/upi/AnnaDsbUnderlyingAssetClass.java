package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbUnderlyingAssetClassMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUnderlyingAssetClass", builder=AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUnderlyingAssetClass", model="drr", builder=AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUnderlyingAssetClass extends RosettaModelObject {

	AnnaDsbUnderlyingAssetClassMeta metaData = new AnnaDsbUnderlyingAssetClassMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbRates getRates();
	AnnaDsbCredit getCredit();
	AnnaDsbCommodities getCommodities();
	AnnaDsbEquity getEquity();
	AnnaDsbForeign_Exchange getForeign_Exchange();

	/*********************** Build Methods  ***********************/
	AnnaDsbUnderlyingAssetClass build();
	
	AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder toBuilder();
	
	static AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder builder() {
		return new AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUnderlyingAssetClass> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUnderlyingAssetClass> getType() {
		return AnnaDsbUnderlyingAssetClass.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Rates"), processor, AnnaDsbRates.class, getRates());
		processRosetta(path.newSubPath("Credit"), processor, AnnaDsbCredit.class, getCredit());
		processRosetta(path.newSubPath("Commodities"), processor, AnnaDsbCommodities.class, getCommodities());
		processRosetta(path.newSubPath("Equity"), processor, AnnaDsbEquity.class, getEquity());
		processRosetta(path.newSubPath("Foreign_Exchange"), processor, AnnaDsbForeign_Exchange.class, getForeign_Exchange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUnderlyingAssetClassBuilder extends AnnaDsbUnderlyingAssetClass, RosettaModelObjectBuilder {
		AnnaDsbRates.AnnaDsbRatesBuilder getOrCreateRates();
		@Override
		AnnaDsbRates.AnnaDsbRatesBuilder getRates();
		AnnaDsbCredit.AnnaDsbCreditBuilder getOrCreateCredit();
		@Override
		AnnaDsbCredit.AnnaDsbCreditBuilder getCredit();
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder getOrCreateCommodities();
		@Override
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder getCommodities();
		AnnaDsbEquity.AnnaDsbEquityBuilder getOrCreateEquity();
		@Override
		AnnaDsbEquity.AnnaDsbEquityBuilder getEquity();
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder getOrCreateForeign_Exchange();
		@Override
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder getForeign_Exchange();
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setRates(AnnaDsbRates Rates);
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setCredit(AnnaDsbCredit Credit);
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setCommodities(AnnaDsbCommodities Commodities);
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setEquity(AnnaDsbEquity Equity);
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setForeign_Exchange(AnnaDsbForeign_Exchange Foreign_Exchange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Rates"), processor, AnnaDsbRates.AnnaDsbRatesBuilder.class, getRates());
			processRosetta(path.newSubPath("Credit"), processor, AnnaDsbCredit.AnnaDsbCreditBuilder.class, getCredit());
			processRosetta(path.newSubPath("Commodities"), processor, AnnaDsbCommodities.AnnaDsbCommoditiesBuilder.class, getCommodities());
			processRosetta(path.newSubPath("Equity"), processor, AnnaDsbEquity.AnnaDsbEquityBuilder.class, getEquity());
			processRosetta(path.newSubPath("Foreign_Exchange"), processor, AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder.class, getForeign_Exchange());
		}
		

		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUnderlyingAssetClass  ***********************/
	class AnnaDsbUnderlyingAssetClassImpl implements AnnaDsbUnderlyingAssetClass {
		private final AnnaDsbRates rates;
		private final AnnaDsbCredit credit;
		private final AnnaDsbCommodities commodities;
		private final AnnaDsbEquity equity;
		private final AnnaDsbForeign_Exchange foreign_Exchange;
		
		protected AnnaDsbUnderlyingAssetClassImpl(AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder builder) {
			this.rates = ofNullable(builder.getRates()).map(f->f.build()).orElse(null);
			this.credit = ofNullable(builder.getCredit()).map(f->f.build()).orElse(null);
			this.commodities = ofNullable(builder.getCommodities()).map(f->f.build()).orElse(null);
			this.equity = ofNullable(builder.getEquity()).map(f->f.build()).orElse(null);
			this.foreign_Exchange = ofNullable(builder.getForeign_Exchange()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Rates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Rates")
		public AnnaDsbRates getRates() {
			return rates;
		}
		
		@Override
		@RosettaAttribute("Credit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Credit")
		public AnnaDsbCredit getCredit() {
			return credit;
		}
		
		@Override
		@RosettaAttribute("Commodities")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Commodities")
		public AnnaDsbCommodities getCommodities() {
			return commodities;
		}
		
		@Override
		@RosettaAttribute("Equity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Equity")
		public AnnaDsbEquity getEquity() {
			return equity;
		}
		
		@Override
		@RosettaAttribute("Foreign_Exchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Foreign_Exchange")
		public AnnaDsbForeign_Exchange getForeign_Exchange() {
			return foreign_Exchange;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetClass build() {
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder toBuilder() {
			AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder builder) {
			ofNullable(getRates()).ifPresent(builder::setRates);
			ofNullable(getCredit()).ifPresent(builder::setCredit);
			ofNullable(getCommodities()).ifPresent(builder::setCommodities);
			ofNullable(getEquity()).ifPresent(builder::setEquity);
			ofNullable(getForeign_Exchange()).ifPresent(builder::setForeign_Exchange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingAssetClass _that = getType().cast(o);
		
			if (!Objects.equals(rates, _that.getRates())) return false;
			if (!Objects.equals(credit, _that.getCredit())) return false;
			if (!Objects.equals(commodities, _that.getCommodities())) return false;
			if (!Objects.equals(equity, _that.getEquity())) return false;
			if (!Objects.equals(foreign_Exchange, _that.getForeign_Exchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rates != null ? rates.hashCode() : 0);
			_result = 31 * _result + (credit != null ? credit.hashCode() : 0);
			_result = 31 * _result + (commodities != null ? commodities.hashCode() : 0);
			_result = 31 * _result + (equity != null ? equity.hashCode() : 0);
			_result = 31 * _result + (foreign_Exchange != null ? foreign_Exchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingAssetClass {" +
				"Rates=" + this.rates + ", " +
				"Credit=" + this.credit + ", " +
				"Commodities=" + this.commodities + ", " +
				"Equity=" + this.equity + ", " +
				"Foreign_Exchange=" + this.foreign_Exchange +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUnderlyingAssetClass  ***********************/
	class AnnaDsbUnderlyingAssetClassBuilderImpl implements AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder {
	
		protected AnnaDsbRates.AnnaDsbRatesBuilder rates;
		protected AnnaDsbCredit.AnnaDsbCreditBuilder credit;
		protected AnnaDsbCommodities.AnnaDsbCommoditiesBuilder commodities;
		protected AnnaDsbEquity.AnnaDsbEquityBuilder equity;
		protected AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder foreign_Exchange;
		
		@Override
		@RosettaAttribute("Rates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Rates")
		public AnnaDsbRates.AnnaDsbRatesBuilder getRates() {
			return rates;
		}
		
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder getOrCreateRates() {
			AnnaDsbRates.AnnaDsbRatesBuilder result;
			if (rates!=null) {
				result = rates;
			}
			else {
				result = rates = AnnaDsbRates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Credit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Credit")
		public AnnaDsbCredit.AnnaDsbCreditBuilder getCredit() {
			return credit;
		}
		
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder getOrCreateCredit() {
			AnnaDsbCredit.AnnaDsbCreditBuilder result;
			if (credit!=null) {
				result = credit;
			}
			else {
				result = credit = AnnaDsbCredit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Commodities")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Commodities")
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder getCommodities() {
			return commodities;
		}
		
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder getOrCreateCommodities() {
			AnnaDsbCommodities.AnnaDsbCommoditiesBuilder result;
			if (commodities!=null) {
				result = commodities;
			}
			else {
				result = commodities = AnnaDsbCommodities.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Equity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Equity")
		public AnnaDsbEquity.AnnaDsbEquityBuilder getEquity() {
			return equity;
		}
		
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder getOrCreateEquity() {
			AnnaDsbEquity.AnnaDsbEquityBuilder result;
			if (equity!=null) {
				result = equity;
			}
			else {
				result = equity = AnnaDsbEquity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Foreign_Exchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Foreign_Exchange")
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder getForeign_Exchange() {
			return foreign_Exchange;
		}
		
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder getOrCreateForeign_Exchange() {
			AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder result;
			if (foreign_Exchange!=null) {
				result = foreign_Exchange;
			}
			else {
				result = foreign_Exchange = AnnaDsbForeign_Exchange.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("Rates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Rates")
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setRates(AnnaDsbRates _rates) {
			this.rates = _rates == null ? null : _rates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Credit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Credit")
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setCredit(AnnaDsbCredit _credit) {
			this.credit = _credit == null ? null : _credit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Commodities")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Commodities")
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setCommodities(AnnaDsbCommodities _commodities) {
			this.commodities = _commodities == null ? null : _commodities.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Equity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Equity")
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setEquity(AnnaDsbEquity _equity) {
			this.equity = _equity == null ? null : _equity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Foreign_Exchange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Foreign_Exchange")
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder setForeign_Exchange(AnnaDsbForeign_Exchange _foreign_Exchange) {
			this.foreign_Exchange = _foreign_Exchange == null ? null : _foreign_Exchange.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetClass build() {
			return new AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassImpl(this);
		}
		
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder prune() {
			if (rates!=null && !rates.prune().hasData()) rates = null;
			if (credit!=null && !credit.prune().hasData()) credit = null;
			if (commodities!=null && !commodities.prune().hasData()) commodities = null;
			if (equity!=null && !equity.prune().hasData()) equity = null;
			if (foreign_Exchange!=null && !foreign_Exchange.prune().hasData()) foreign_Exchange = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRates()!=null && getRates().hasData()) return true;
			if (getCredit()!=null && getCredit().hasData()) return true;
			if (getCommodities()!=null && getCommodities().hasData()) return true;
			if (getEquity()!=null && getEquity().hasData()) return true;
			if (getForeign_Exchange()!=null && getForeign_Exchange().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder o = (AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder) other;
			
			merger.mergeRosetta(getRates(), o.getRates(), this::setRates);
			merger.mergeRosetta(getCredit(), o.getCredit(), this::setCredit);
			merger.mergeRosetta(getCommodities(), o.getCommodities(), this::setCommodities);
			merger.mergeRosetta(getEquity(), o.getEquity(), this::setEquity);
			merger.mergeRosetta(getForeign_Exchange(), o.getForeign_Exchange(), this::setForeign_Exchange);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingAssetClass _that = getType().cast(o);
		
			if (!Objects.equals(rates, _that.getRates())) return false;
			if (!Objects.equals(credit, _that.getCredit())) return false;
			if (!Objects.equals(commodities, _that.getCommodities())) return false;
			if (!Objects.equals(equity, _that.getEquity())) return false;
			if (!Objects.equals(foreign_Exchange, _that.getForeign_Exchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rates != null ? rates.hashCode() : 0);
			_result = 31 * _result + (credit != null ? credit.hashCode() : 0);
			_result = 31 * _result + (commodities != null ? commodities.hashCode() : 0);
			_result = 31 * _result + (equity != null ? equity.hashCode() : 0);
			_result = 31 * _result + (foreign_Exchange != null ? foreign_Exchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingAssetClassBuilder {" +
				"Rates=" + this.rates + ", " +
				"Credit=" + this.credit + ", " +
				"Commodities=" + this.commodities + ", " +
				"Equity=" + this.equity + ", " +
				"Foreign_Exchange=" + this.foreign_Exchange +
			'}';
		}
	}
}
