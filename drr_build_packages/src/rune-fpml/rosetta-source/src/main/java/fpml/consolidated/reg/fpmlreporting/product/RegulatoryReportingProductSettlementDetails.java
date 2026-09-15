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
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductSettlementDetailsMeta;
import fpml.consolidated.shared.BusinessCenter;
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
 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductSettlementDetails", builder=RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductSettlementDetails", model="fpml", builder=RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductSettlementDetails extends RosettaModelObject {

	RegulatoryReportingProductSettlementDetailsMeta metaData = new RegulatoryReportingProductSettlementDetailsMeta();

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
	SettlementTypeEnum getSettlementMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	Currency getSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	BusinessCenter getSettlementLocation();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductSettlementDetails build();
	
	RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder toBuilder();
	
	static RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder builder() {
		return new RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductSettlementDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductSettlementDetails> getType() {
		return RegulatoryReportingProductSettlementDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("settlementMethod"), SettlementTypeEnum.class, getSettlementMethod(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("settlementLocation"), processor, BusinessCenter.class, getSettlementLocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductSettlementDetailsBuilder extends RegulatoryReportingProductSettlementDetails, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		BusinessCenter.BusinessCenterBuilder getOrCreateSettlementLocation();
		@Override
		BusinessCenter.BusinessCenterBuilder getSettlementLocation();
		RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder setSettlementMethod(SettlementTypeEnum settlementMethod);
		RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder setSettlementCurrency(Currency settlementCurrency);
		RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder setSettlementLocation(BusinessCenter settlementLocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("settlementMethod"), SettlementTypeEnum.class, getSettlementMethod(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("settlementLocation"), processor, BusinessCenter.BusinessCenterBuilder.class, getSettlementLocation());
		}
		

		RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductSettlementDetails  ***********************/
	class RegulatoryReportingProductSettlementDetailsImpl implements RegulatoryReportingProductSettlementDetails {
		private final SettlementTypeEnum settlementMethod;
		private final Currency settlementCurrency;
		private final BusinessCenter settlementLocation;
		
		protected RegulatoryReportingProductSettlementDetailsImpl(RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder builder) {
			this.settlementMethod = builder.getSettlementMethod();
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.settlementLocation = ofNullable(builder.getSettlementLocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethod")
		public SettlementTypeEnum getSettlementMethod() {
			return settlementMethod;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public BusinessCenter getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		public RegulatoryReportingProductSettlementDetails build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder toBuilder() {
			RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder builder) {
			ofNullable(getSettlementMethod()).ifPresent(builder::setSettlementMethod);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSettlementLocation()).ifPresent(builder::setSettlementLocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductSettlementDetails _that = getType().cast(o);
		
			if (!Objects.equals(settlementMethod, _that.getSettlementMethod())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementMethod != null ? settlementMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductSettlementDetails {" +
				"settlementMethod=" + this.settlementMethod + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementLocation=" + this.settlementLocation +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductSettlementDetails  ***********************/
	class RegulatoryReportingProductSettlementDetailsBuilderImpl implements RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder {
	
		protected SettlementTypeEnum settlementMethod;
		protected Currency.CurrencyBuilder settlementCurrency;
		protected BusinessCenter.BusinessCenterBuilder settlementLocation;
		
		@Override
		@RosettaAttribute("settlementMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethod")
		public SettlementTypeEnum getSettlementMethod() {
			return settlementMethod;
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
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public BusinessCenter.BusinessCenterBuilder getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateSettlementLocation() {
			BusinessCenter.BusinessCenterBuilder result;
			if (settlementLocation!=null) {
				result = settlementLocation;
			}
			else {
				result = settlementLocation = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("settlementMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementMethod")
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder setSettlementMethod(SettlementTypeEnum _settlementMethod) {
			this.settlementMethod = _settlementMethod == null ? null : _settlementMethod;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder setSettlementLocation(BusinessCenter _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryReportingProductSettlementDetails build() {
			return new RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (settlementLocation!=null && !settlementLocation.prune().hasData()) settlementLocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementMethod()!=null) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getSettlementLocation()!=null && getSettlementLocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder o = (RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getSettlementLocation(), o.getSettlementLocation(), this::setSettlementLocation);
			
			merger.mergeBasic(getSettlementMethod(), o.getSettlementMethod(), this::setSettlementMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductSettlementDetails _that = getType().cast(o);
		
			if (!Objects.equals(settlementMethod, _that.getSettlementMethod())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementMethod != null ? settlementMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductSettlementDetailsBuilder {" +
				"settlementMethod=" + this.settlementMethod + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementLocation=" + this.settlementLocation +
			'}';
		}
	}
}
