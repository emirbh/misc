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
import drr.regulation.common.meta.CSAPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Enriched party information required for reporting a transaction under CSA.
 * @version 7.7.0
 */
@RosettaDataType(value="CSAPartyInformation", builder=CSAPartyInformation.CSAPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CSAPartyInformation", model="drr", builder=CSAPartyInformation.CSAPartyInformationBuilderImpl.class, version="7.7.0")
public interface CSAPartyInformation extends RosettaModelObject {

	CSAPartyInformationMeta metaData = new CSAPartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the portfolio contains non reported transactions.
	 */
	Boolean getNonReportedTradePortfolio();
	/**
	 * Indicator of whether the counterparty is a local counterparty for the jurisdiction.
	 */
	Boolean getLocalCounterparty();

	/*********************** Build Methods  ***********************/
	CSAPartyInformation build();
	
	CSAPartyInformation.CSAPartyInformationBuilder toBuilder();
	
	static CSAPartyInformation.CSAPartyInformationBuilder builder() {
		return new CSAPartyInformation.CSAPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSAPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSAPartyInformation> getType() {
		return CSAPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
		processor.processBasic(path.newSubPath("localCounterparty"), Boolean.class, getLocalCounterparty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSAPartyInformationBuilder extends CSAPartyInformation, RosettaModelObjectBuilder {
		CSAPartyInformation.CSAPartyInformationBuilder setNonReportedTradePortfolio(Boolean nonReportedTradePortfolio);
		CSAPartyInformation.CSAPartyInformationBuilder setLocalCounterparty(Boolean localCounterparty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
			processor.processBasic(path.newSubPath("localCounterparty"), Boolean.class, getLocalCounterparty(), this);
		}
		

		CSAPartyInformation.CSAPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of CSAPartyInformation  ***********************/
	class CSAPartyInformationImpl implements CSAPartyInformation {
		private final Boolean nonReportedTradePortfolio;
		private final Boolean localCounterparty;
		
		protected CSAPartyInformationImpl(CSAPartyInformation.CSAPartyInformationBuilder builder) {
			this.nonReportedTradePortfolio = builder.getNonReportedTradePortfolio();
			this.localCounterparty = builder.getLocalCounterparty();
		}
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@Override
		@RosettaAttribute("localCounterparty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localCounterparty")
		public Boolean getLocalCounterparty() {
			return localCounterparty;
		}
		
		@Override
		public CSAPartyInformation build() {
			return this;
		}
		
		@Override
		public CSAPartyInformation.CSAPartyInformationBuilder toBuilder() {
			CSAPartyInformation.CSAPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSAPartyInformation.CSAPartyInformationBuilder builder) {
			ofNullable(getNonReportedTradePortfolio()).ifPresent(builder::setNonReportedTradePortfolio);
			ofNullable(getLocalCounterparty()).ifPresent(builder::setLocalCounterparty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			if (!Objects.equals(localCounterparty, _that.getLocalCounterparty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			_result = 31 * _result + (localCounterparty != null ? localCounterparty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAPartyInformation {" +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio + ", " +
				"localCounterparty=" + this.localCounterparty +
			'}';
		}
	}

	/*********************** Builder Implementation of CSAPartyInformation  ***********************/
	class CSAPartyInformationBuilderImpl implements CSAPartyInformation.CSAPartyInformationBuilder {
	
		protected Boolean nonReportedTradePortfolio;
		protected Boolean localCounterparty;
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@Override
		@RosettaAttribute("localCounterparty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localCounterparty")
		public Boolean getLocalCounterparty() {
			return localCounterparty;
		}
		
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		@Override
		public CSAPartyInformation.CSAPartyInformationBuilder setNonReportedTradePortfolio(Boolean _nonReportedTradePortfolio) {
			this.nonReportedTradePortfolio = _nonReportedTradePortfolio == null ? null : _nonReportedTradePortfolio;
			return this;
		}
		
		@RosettaAttribute("localCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localCounterparty")
		@Override
		public CSAPartyInformation.CSAPartyInformationBuilder setLocalCounterparty(Boolean _localCounterparty) {
			this.localCounterparty = _localCounterparty == null ? null : _localCounterparty;
			return this;
		}
		
		@Override
		public CSAPartyInformation build() {
			return new CSAPartyInformation.CSAPartyInformationImpl(this);
		}
		
		@Override
		public CSAPartyInformation.CSAPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAPartyInformation.CSAPartyInformationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonReportedTradePortfolio()!=null) return true;
			if (getLocalCounterparty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAPartyInformation.CSAPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CSAPartyInformation.CSAPartyInformationBuilder o = (CSAPartyInformation.CSAPartyInformationBuilder) other;
			
			
			merger.mergeBasic(getNonReportedTradePortfolio(), o.getNonReportedTradePortfolio(), this::setNonReportedTradePortfolio);
			merger.mergeBasic(getLocalCounterparty(), o.getLocalCounterparty(), this::setLocalCounterparty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			if (!Objects.equals(localCounterparty, _that.getLocalCounterparty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			_result = 31 * _result + (localCounterparty != null ? localCounterparty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAPartyInformationBuilder {" +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio + ", " +
				"localCounterparty=" + this.localCounterparty +
			'}';
		}
	}
}
