package drr.regulation.common;

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
import drr.regulation.common.meta.ASICPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Enriched party information required for reporting a transaction under ASIC.
 * @version 7.7.0
 */
@RosettaDataType(value="ASICPartyInformation", builder=ASICPartyInformation.ASICPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ASICPartyInformation", model="drr", builder=ASICPartyInformation.ASICPartyInformationBuilderImpl.class, version="7.7.0")
public interface ASICPartyInformation extends RosettaModelObject {

	ASICPartyInformationMeta metaData = new ASICPartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the portfolio contains non reported transactions.
	 */
	Boolean getNonReportedTradePortfolio();
	/**
	 * Indicator whether the reporting enitity is acting as a small-scale buy side and meets the &#39;small-scale&#39; criteria
	 */
	Boolean getSmallScaleBuySideIndicator();

	/*********************** Build Methods  ***********************/
	ASICPartyInformation build();
	
	ASICPartyInformation.ASICPartyInformationBuilder toBuilder();
	
	static ASICPartyInformation.ASICPartyInformationBuilder builder() {
		return new ASICPartyInformation.ASICPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ASICPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ASICPartyInformation> getType() {
		return ASICPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
		processor.processBasic(path.newSubPath("smallScaleBuySideIndicator"), Boolean.class, getSmallScaleBuySideIndicator(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ASICPartyInformationBuilder extends ASICPartyInformation, RosettaModelObjectBuilder {
		ASICPartyInformation.ASICPartyInformationBuilder setNonReportedTradePortfolio(Boolean nonReportedTradePortfolio);
		ASICPartyInformation.ASICPartyInformationBuilder setSmallScaleBuySideIndicator(Boolean smallScaleBuySideIndicator);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
			processor.processBasic(path.newSubPath("smallScaleBuySideIndicator"), Boolean.class, getSmallScaleBuySideIndicator(), this);
		}
		

		ASICPartyInformation.ASICPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of ASICPartyInformation  ***********************/
	class ASICPartyInformationImpl implements ASICPartyInformation {
		private final Boolean nonReportedTradePortfolio;
		private final Boolean smallScaleBuySideIndicator;
		
		protected ASICPartyInformationImpl(ASICPartyInformation.ASICPartyInformationBuilder builder) {
			this.nonReportedTradePortfolio = builder.getNonReportedTradePortfolio();
			this.smallScaleBuySideIndicator = builder.getSmallScaleBuySideIndicator();
		}
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@Override
		@RosettaAttribute("smallScaleBuySideIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("smallScaleBuySideIndicator")
		public Boolean getSmallScaleBuySideIndicator() {
			return smallScaleBuySideIndicator;
		}
		
		@Override
		public ASICPartyInformation build() {
			return this;
		}
		
		@Override
		public ASICPartyInformation.ASICPartyInformationBuilder toBuilder() {
			ASICPartyInformation.ASICPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ASICPartyInformation.ASICPartyInformationBuilder builder) {
			ofNullable(getNonReportedTradePortfolio()).ifPresent(builder::setNonReportedTradePortfolio);
			ofNullable(getSmallScaleBuySideIndicator()).ifPresent(builder::setSmallScaleBuySideIndicator);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ASICPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			if (!Objects.equals(smallScaleBuySideIndicator, _that.getSmallScaleBuySideIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			_result = 31 * _result + (smallScaleBuySideIndicator != null ? smallScaleBuySideIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ASICPartyInformation {" +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio + ", " +
				"smallScaleBuySideIndicator=" + this.smallScaleBuySideIndicator +
			'}';
		}
	}

	/*********************** Builder Implementation of ASICPartyInformation  ***********************/
	class ASICPartyInformationBuilderImpl implements ASICPartyInformation.ASICPartyInformationBuilder {
	
		protected Boolean nonReportedTradePortfolio;
		protected Boolean smallScaleBuySideIndicator;
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@Override
		@RosettaAttribute("smallScaleBuySideIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("smallScaleBuySideIndicator")
		public Boolean getSmallScaleBuySideIndicator() {
			return smallScaleBuySideIndicator;
		}
		
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		@Override
		public ASICPartyInformation.ASICPartyInformationBuilder setNonReportedTradePortfolio(Boolean _nonReportedTradePortfolio) {
			this.nonReportedTradePortfolio = _nonReportedTradePortfolio == null ? null : _nonReportedTradePortfolio;
			return this;
		}
		
		@RosettaAttribute("smallScaleBuySideIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("smallScaleBuySideIndicator")
		@Override
		public ASICPartyInformation.ASICPartyInformationBuilder setSmallScaleBuySideIndicator(Boolean _smallScaleBuySideIndicator) {
			this.smallScaleBuySideIndicator = _smallScaleBuySideIndicator == null ? null : _smallScaleBuySideIndicator;
			return this;
		}
		
		@Override
		public ASICPartyInformation build() {
			return new ASICPartyInformation.ASICPartyInformationImpl(this);
		}
		
		@Override
		public ASICPartyInformation.ASICPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ASICPartyInformation.ASICPartyInformationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonReportedTradePortfolio()!=null) return true;
			if (getSmallScaleBuySideIndicator()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ASICPartyInformation.ASICPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ASICPartyInformation.ASICPartyInformationBuilder o = (ASICPartyInformation.ASICPartyInformationBuilder) other;
			
			
			merger.mergeBasic(getNonReportedTradePortfolio(), o.getNonReportedTradePortfolio(), this::setNonReportedTradePortfolio);
			merger.mergeBasic(getSmallScaleBuySideIndicator(), o.getSmallScaleBuySideIndicator(), this::setSmallScaleBuySideIndicator);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ASICPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			if (!Objects.equals(smallScaleBuySideIndicator, _that.getSmallScaleBuySideIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			_result = 31 * _result + (smallScaleBuySideIndicator != null ? smallScaleBuySideIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ASICPartyInformationBuilder {" +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio + ", " +
				"smallScaleBuySideIndicator=" + this.smallScaleBuySideIndicator +
			'}';
		}
	}
}
