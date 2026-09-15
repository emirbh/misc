package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductNonCDEFxDetailsMeta;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision FX-related data elements not called out in CPMI-IOSCO CDE. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductNonCDEFxDetails", builder=RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductNonCDEFxDetails", model="fpml", builder=RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductNonCDEFxDetails extends RosettaModelObject {

	RegulatoryReportingProductNonCDEFxDetailsMeta metaData = new RegulatoryReportingProductNonCDEFxDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	String getFxType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	Currency getDeliveryCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	Currency getDeliveryCurrency2();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	BigDecimal getForwardExchangeRate();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductNonCDEFxDetails build();
	
	RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder toBuilder();
	
	static RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder builder() {
		return new RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductNonCDEFxDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductNonCDEFxDetails> getType() {
		return RegulatoryReportingProductNonCDEFxDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fxType"), String.class, getFxType(), this);
		processRosetta(path.newSubPath("deliveryCurrency"), processor, Currency.class, getDeliveryCurrency());
		processRosetta(path.newSubPath("deliveryCurrency2"), processor, Currency.class, getDeliveryCurrency2());
		processor.processBasic(path.newSubPath("forwardExchangeRate"), BigDecimal.class, getForwardExchangeRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductNonCDEFxDetailsBuilder extends RegulatoryReportingProductNonCDEFxDetails, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateDeliveryCurrency();
		@Override
		Currency.CurrencyBuilder getDeliveryCurrency();
		Currency.CurrencyBuilder getOrCreateDeliveryCurrency2();
		@Override
		Currency.CurrencyBuilder getDeliveryCurrency2();
		RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setFxType(String fxType);
		RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setDeliveryCurrency(Currency deliveryCurrency);
		RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setDeliveryCurrency2(Currency deliveryCurrency2);
		RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setForwardExchangeRate(BigDecimal forwardExchangeRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fxType"), String.class, getFxType(), this);
			processRosetta(path.newSubPath("deliveryCurrency"), processor, Currency.CurrencyBuilder.class, getDeliveryCurrency());
			processRosetta(path.newSubPath("deliveryCurrency2"), processor, Currency.CurrencyBuilder.class, getDeliveryCurrency2());
			processor.processBasic(path.newSubPath("forwardExchangeRate"), BigDecimal.class, getForwardExchangeRate(), this);
		}
		

		RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductNonCDEFxDetails  ***********************/
	class RegulatoryReportingProductNonCDEFxDetailsImpl implements RegulatoryReportingProductNonCDEFxDetails {
		private final String fxType;
		private final Currency deliveryCurrency;
		private final Currency deliveryCurrency2;
		private final BigDecimal forwardExchangeRate;
		
		protected RegulatoryReportingProductNonCDEFxDetailsImpl(RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder builder) {
			this.fxType = builder.getFxType();
			this.deliveryCurrency = ofNullable(builder.getDeliveryCurrency()).map(f->f.build()).orElse(null);
			this.deliveryCurrency2 = ofNullable(builder.getDeliveryCurrency2()).map(f->f.build()).orElse(null);
			this.forwardExchangeRate = builder.getForwardExchangeRate();
		}
		
		@Override
		@RosettaAttribute("fxType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxType")
		public String getFxType() {
			return fxType;
		}
		
		@Override
		@RosettaAttribute("deliveryCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryCurrency")
		public Currency getDeliveryCurrency() {
			return deliveryCurrency;
		}
		
		@Override
		@RosettaAttribute("deliveryCurrency2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryCurrency2")
		public Currency getDeliveryCurrency2() {
			return deliveryCurrency2;
		}
		
		@Override
		@RosettaAttribute("forwardExchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardExchangeRate")
		public BigDecimal getForwardExchangeRate() {
			return forwardExchangeRate;
		}
		
		@Override
		public RegulatoryReportingProductNonCDEFxDetails build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder toBuilder() {
			RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder builder) {
			ofNullable(getFxType()).ifPresent(builder::setFxType);
			ofNullable(getDeliveryCurrency()).ifPresent(builder::setDeliveryCurrency);
			ofNullable(getDeliveryCurrency2()).ifPresent(builder::setDeliveryCurrency2);
			ofNullable(getForwardExchangeRate()).ifPresent(builder::setForwardExchangeRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductNonCDEFxDetails _that = getType().cast(o);
		
			if (!Objects.equals(fxType, _that.getFxType())) return false;
			if (!Objects.equals(deliveryCurrency, _that.getDeliveryCurrency())) return false;
			if (!Objects.equals(deliveryCurrency2, _that.getDeliveryCurrency2())) return false;
			if (!Objects.equals(forwardExchangeRate, _that.getForwardExchangeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxType != null ? fxType.hashCode() : 0);
			_result = 31 * _result + (deliveryCurrency != null ? deliveryCurrency.hashCode() : 0);
			_result = 31 * _result + (deliveryCurrency2 != null ? deliveryCurrency2.hashCode() : 0);
			_result = 31 * _result + (forwardExchangeRate != null ? forwardExchangeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductNonCDEFxDetails {" +
				"fxType=" + this.fxType + ", " +
				"deliveryCurrency=" + this.deliveryCurrency + ", " +
				"deliveryCurrency2=" + this.deliveryCurrency2 + ", " +
				"forwardExchangeRate=" + this.forwardExchangeRate +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductNonCDEFxDetails  ***********************/
	class RegulatoryReportingProductNonCDEFxDetailsBuilderImpl implements RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder {
	
		protected String fxType;
		protected Currency.CurrencyBuilder deliveryCurrency;
		protected Currency.CurrencyBuilder deliveryCurrency2;
		protected BigDecimal forwardExchangeRate;
		
		@Override
		@RosettaAttribute("fxType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxType")
		public String getFxType() {
			return fxType;
		}
		
		@Override
		@RosettaAttribute("deliveryCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryCurrency")
		public Currency.CurrencyBuilder getDeliveryCurrency() {
			return deliveryCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateDeliveryCurrency() {
			Currency.CurrencyBuilder result;
			if (deliveryCurrency!=null) {
				result = deliveryCurrency;
			}
			else {
				result = deliveryCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryCurrency2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryCurrency2")
		public Currency.CurrencyBuilder getDeliveryCurrency2() {
			return deliveryCurrency2;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateDeliveryCurrency2() {
			Currency.CurrencyBuilder result;
			if (deliveryCurrency2!=null) {
				result = deliveryCurrency2;
			}
			else {
				result = deliveryCurrency2 = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forwardExchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardExchangeRate")
		public BigDecimal getForwardExchangeRate() {
			return forwardExchangeRate;
		}
		
		@RosettaAttribute("fxType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxType")
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setFxType(String _fxType) {
			this.fxType = _fxType == null ? null : _fxType;
			return this;
		}
		
		@RosettaAttribute("deliveryCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryCurrency")
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setDeliveryCurrency(Currency _deliveryCurrency) {
			this.deliveryCurrency = _deliveryCurrency == null ? null : _deliveryCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryCurrency2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryCurrency2")
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setDeliveryCurrency2(Currency _deliveryCurrency2) {
			this.deliveryCurrency2 = _deliveryCurrency2 == null ? null : _deliveryCurrency2.toBuilder();
			return this;
		}
		
		@RosettaAttribute("forwardExchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forwardExchangeRate")
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder setForwardExchangeRate(BigDecimal _forwardExchangeRate) {
			this.forwardExchangeRate = _forwardExchangeRate == null ? null : _forwardExchangeRate;
			return this;
		}
		
		@Override
		public RegulatoryReportingProductNonCDEFxDetails build() {
			return new RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder prune() {
			if (deliveryCurrency!=null && !deliveryCurrency.prune().hasData()) deliveryCurrency = null;
			if (deliveryCurrency2!=null && !deliveryCurrency2.prune().hasData()) deliveryCurrency2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxType()!=null) return true;
			if (getDeliveryCurrency()!=null && getDeliveryCurrency().hasData()) return true;
			if (getDeliveryCurrency2()!=null && getDeliveryCurrency2().hasData()) return true;
			if (getForwardExchangeRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder o = (RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder) other;
			
			merger.mergeRosetta(getDeliveryCurrency(), o.getDeliveryCurrency(), this::setDeliveryCurrency);
			merger.mergeRosetta(getDeliveryCurrency2(), o.getDeliveryCurrency2(), this::setDeliveryCurrency2);
			
			merger.mergeBasic(getFxType(), o.getFxType(), this::setFxType);
			merger.mergeBasic(getForwardExchangeRate(), o.getForwardExchangeRate(), this::setForwardExchangeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductNonCDEFxDetails _that = getType().cast(o);
		
			if (!Objects.equals(fxType, _that.getFxType())) return false;
			if (!Objects.equals(deliveryCurrency, _that.getDeliveryCurrency())) return false;
			if (!Objects.equals(deliveryCurrency2, _that.getDeliveryCurrency2())) return false;
			if (!Objects.equals(forwardExchangeRate, _that.getForwardExchangeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxType != null ? fxType.hashCode() : 0);
			_result = 31 * _result + (deliveryCurrency != null ? deliveryCurrency.hashCode() : 0);
			_result = 31 * _result + (deliveryCurrency2 != null ? deliveryCurrency2.hashCode() : 0);
			_result = 31 * _result + (forwardExchangeRate != null ? forwardExchangeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductNonCDEFxDetailsBuilder {" +
				"fxType=" + this.fxType + ", " +
				"deliveryCurrency=" + this.deliveryCurrency + ", " +
				"deliveryCurrency2=" + this.deliveryCurrency2 + ", " +
				"forwardExchangeRate=" + this.forwardExchangeRate +
			'}';
		}
	}
}
