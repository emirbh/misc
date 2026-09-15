package drr.base.trade;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
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
import drr.base.trade.meta.ReportingSideMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the reporting roles for a ReportableEvent or ReportableCollateral.
 * @version 7.7.0
 */
@RosettaDataType(value="ReportingSide", builder=ReportingSide.ReportingSideBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportingSide", model="drr", builder=ReportingSide.ReportingSideBuilderImpl.class, version="7.7.0")
public interface ReportingSide extends RosettaModelObject {

	ReportingSideMeta metaData = new ReportingSideMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The counterparty to the transaction (buyer or seller of the contract) from whose perspective the transaction is being reported.
	 */
	ReferenceWithMetaParty getReportingParty();
	/**
	 * The counterparty to the transaction (buyer or seller of the contract) on the non-reporting side.
	 */
	ReferenceWithMetaParty getReportingCounterparty();
	/**
	 * The party responsibility for submitting the transaction report to the authority.
	 */
	ReferenceWithMetaParty getPartyResponsibleForReporting();
	/**
	 * The party submitting the transaction report to the authority.
	 */
	ReferenceWithMetaParty getReportSubmittingParty();

	/*********************** Build Methods  ***********************/
	ReportingSide build();
	
	ReportingSide.ReportingSideBuilder toBuilder();
	
	static ReportingSide.ReportingSideBuilder builder() {
		return new ReportingSide.ReportingSideBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingSide> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportingSide> getType() {
		return ReportingSide.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportingParty"), processor, ReferenceWithMetaParty.class, getReportingParty());
		processRosetta(path.newSubPath("reportingCounterparty"), processor, ReferenceWithMetaParty.class, getReportingCounterparty());
		processRosetta(path.newSubPath("partyResponsibleForReporting"), processor, ReferenceWithMetaParty.class, getPartyResponsibleForReporting());
		processRosetta(path.newSubPath("reportSubmittingParty"), processor, ReferenceWithMetaParty.class, getReportSubmittingParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingSideBuilder extends ReportingSide, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReportingParty();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReportingParty();
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReportingCounterparty();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReportingCounterparty();
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyResponsibleForReporting();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyResponsibleForReporting();
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReportSubmittingParty();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReportSubmittingParty();
		ReportingSide.ReportingSideBuilder setReportingParty(ReferenceWithMetaParty reportingParty);
		ReportingSide.ReportingSideBuilder setReportingPartyValue(Party reportingParty);
		ReportingSide.ReportingSideBuilder setReportingCounterparty(ReferenceWithMetaParty reportingCounterparty);
		ReportingSide.ReportingSideBuilder setReportingCounterpartyValue(Party reportingCounterparty);
		ReportingSide.ReportingSideBuilder setPartyResponsibleForReporting(ReferenceWithMetaParty partyResponsibleForReporting);
		ReportingSide.ReportingSideBuilder setPartyResponsibleForReportingValue(Party partyResponsibleForReporting);
		ReportingSide.ReportingSideBuilder setReportSubmittingParty(ReferenceWithMetaParty reportSubmittingParty);
		ReportingSide.ReportingSideBuilder setReportSubmittingPartyValue(Party reportSubmittingParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportingParty"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getReportingParty());
			processRosetta(path.newSubPath("reportingCounterparty"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getReportingCounterparty());
			processRosetta(path.newSubPath("partyResponsibleForReporting"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPartyResponsibleForReporting());
			processRosetta(path.newSubPath("reportSubmittingParty"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getReportSubmittingParty());
		}
		

		ReportingSide.ReportingSideBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingSide  ***********************/
	class ReportingSideImpl implements ReportingSide {
		private final ReferenceWithMetaParty reportingParty;
		private final ReferenceWithMetaParty reportingCounterparty;
		private final ReferenceWithMetaParty partyResponsibleForReporting;
		private final ReferenceWithMetaParty reportSubmittingParty;
		
		protected ReportingSideImpl(ReportingSide.ReportingSideBuilder builder) {
			this.reportingParty = ofNullable(builder.getReportingParty()).map(f->f.build()).orElse(null);
			this.reportingCounterparty = ofNullable(builder.getReportingCounterparty()).map(f->f.build()).orElse(null);
			this.partyResponsibleForReporting = ofNullable(builder.getPartyResponsibleForReporting()).map(f->f.build()).orElse(null);
			this.reportSubmittingParty = ofNullable(builder.getReportSubmittingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportingParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingParty")
		public ReferenceWithMetaParty getReportingParty() {
			return reportingParty;
		}
		
		@Override
		@RosettaAttribute("reportingCounterparty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingCounterparty")
		public ReferenceWithMetaParty getReportingCounterparty() {
			return reportingCounterparty;
		}
		
		@Override
		@RosettaAttribute("partyResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyResponsibleForReporting")
		public ReferenceWithMetaParty getPartyResponsibleForReporting() {
			return partyResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("reportSubmittingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportSubmittingParty")
		public ReferenceWithMetaParty getReportSubmittingParty() {
			return reportSubmittingParty;
		}
		
		@Override
		public ReportingSide build() {
			return this;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder toBuilder() {
			ReportingSide.ReportingSideBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingSide.ReportingSideBuilder builder) {
			ofNullable(getReportingParty()).ifPresent(builder::setReportingParty);
			ofNullable(getReportingCounterparty()).ifPresent(builder::setReportingCounterparty);
			ofNullable(getPartyResponsibleForReporting()).ifPresent(builder::setPartyResponsibleForReporting);
			ofNullable(getReportSubmittingParty()).ifPresent(builder::setReportSubmittingParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingSide _that = getType().cast(o);
		
			if (!Objects.equals(reportingParty, _that.getReportingParty())) return false;
			if (!Objects.equals(reportingCounterparty, _that.getReportingCounterparty())) return false;
			if (!Objects.equals(partyResponsibleForReporting, _that.getPartyResponsibleForReporting())) return false;
			if (!Objects.equals(reportSubmittingParty, _that.getReportSubmittingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingParty != null ? reportingParty.hashCode() : 0);
			_result = 31 * _result + (reportingCounterparty != null ? reportingCounterparty.hashCode() : 0);
			_result = 31 * _result + (partyResponsibleForReporting != null ? partyResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingParty != null ? reportSubmittingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingSide {" +
				"reportingParty=" + this.reportingParty + ", " +
				"reportingCounterparty=" + this.reportingCounterparty + ", " +
				"partyResponsibleForReporting=" + this.partyResponsibleForReporting + ", " +
				"reportSubmittingParty=" + this.reportSubmittingParty +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingSide  ***********************/
	class ReportingSideBuilderImpl implements ReportingSide.ReportingSideBuilder {
	
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder reportingParty;
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder reportingCounterparty;
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyResponsibleForReporting;
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder reportSubmittingParty;
		
		@Override
		@RosettaAttribute("reportingParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingParty")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReportingParty() {
			return reportingParty;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReportingParty() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (reportingParty!=null) {
				result = reportingParty;
			}
			else {
				result = reportingParty = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingCounterparty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingCounterparty")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReportingCounterparty() {
			return reportingCounterparty;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReportingCounterparty() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (reportingCounterparty!=null) {
				result = reportingCounterparty;
			}
			else {
				result = reportingCounterparty = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyResponsibleForReporting")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyResponsibleForReporting() {
			return partyResponsibleForReporting;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyResponsibleForReporting() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (partyResponsibleForReporting!=null) {
				result = partyResponsibleForReporting;
			}
			else {
				result = partyResponsibleForReporting = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportSubmittingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportSubmittingParty")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReportSubmittingParty() {
			return reportSubmittingParty;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReportSubmittingParty() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (reportSubmittingParty!=null) {
				result = reportSubmittingParty;
			}
			else {
				result = reportSubmittingParty = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("reportingParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingParty")
		@Override
		public ReportingSide.ReportingSideBuilder setReportingParty(ReferenceWithMetaParty _reportingParty) {
			this.reportingParty = _reportingParty == null ? null : _reportingParty.toBuilder();
			return this;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder setReportingPartyValue(Party _reportingParty) {
			this.getOrCreateReportingParty().setValue(_reportingParty);
			return this;
		}
		
		@RosettaAttribute("reportingCounterparty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingCounterparty")
		@Override
		public ReportingSide.ReportingSideBuilder setReportingCounterparty(ReferenceWithMetaParty _reportingCounterparty) {
			this.reportingCounterparty = _reportingCounterparty == null ? null : _reportingCounterparty.toBuilder();
			return this;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder setReportingCounterpartyValue(Party _reportingCounterparty) {
			this.getOrCreateReportingCounterparty().setValue(_reportingCounterparty);
			return this;
		}
		
		@RosettaAttribute("partyResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyResponsibleForReporting")
		@Override
		public ReportingSide.ReportingSideBuilder setPartyResponsibleForReporting(ReferenceWithMetaParty _partyResponsibleForReporting) {
			this.partyResponsibleForReporting = _partyResponsibleForReporting == null ? null : _partyResponsibleForReporting.toBuilder();
			return this;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder setPartyResponsibleForReportingValue(Party _partyResponsibleForReporting) {
			this.getOrCreatePartyResponsibleForReporting().setValue(_partyResponsibleForReporting);
			return this;
		}
		
		@RosettaAttribute("reportSubmittingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportSubmittingParty")
		@Override
		public ReportingSide.ReportingSideBuilder setReportSubmittingParty(ReferenceWithMetaParty _reportSubmittingParty) {
			this.reportSubmittingParty = _reportSubmittingParty == null ? null : _reportSubmittingParty.toBuilder();
			return this;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder setReportSubmittingPartyValue(Party _reportSubmittingParty) {
			this.getOrCreateReportSubmittingParty().setValue(_reportSubmittingParty);
			return this;
		}
		
		@Override
		public ReportingSide build() {
			return new ReportingSide.ReportingSideImpl(this);
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingSide.ReportingSideBuilder prune() {
			if (reportingParty!=null && !reportingParty.prune().hasData()) reportingParty = null;
			if (reportingCounterparty!=null && !reportingCounterparty.prune().hasData()) reportingCounterparty = null;
			if (partyResponsibleForReporting!=null && !partyResponsibleForReporting.prune().hasData()) partyResponsibleForReporting = null;
			if (reportSubmittingParty!=null && !reportSubmittingParty.prune().hasData()) reportSubmittingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportingParty()!=null && getReportingParty().hasData()) return true;
			if (getReportingCounterparty()!=null && getReportingCounterparty().hasData()) return true;
			if (getPartyResponsibleForReporting()!=null && getPartyResponsibleForReporting().hasData()) return true;
			if (getReportSubmittingParty()!=null && getReportSubmittingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingSide.ReportingSideBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingSide.ReportingSideBuilder o = (ReportingSide.ReportingSideBuilder) other;
			
			merger.mergeRosetta(getReportingParty(), o.getReportingParty(), this::setReportingParty);
			merger.mergeRosetta(getReportingCounterparty(), o.getReportingCounterparty(), this::setReportingCounterparty);
			merger.mergeRosetta(getPartyResponsibleForReporting(), o.getPartyResponsibleForReporting(), this::setPartyResponsibleForReporting);
			merger.mergeRosetta(getReportSubmittingParty(), o.getReportSubmittingParty(), this::setReportSubmittingParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingSide _that = getType().cast(o);
		
			if (!Objects.equals(reportingParty, _that.getReportingParty())) return false;
			if (!Objects.equals(reportingCounterparty, _that.getReportingCounterparty())) return false;
			if (!Objects.equals(partyResponsibleForReporting, _that.getPartyResponsibleForReporting())) return false;
			if (!Objects.equals(reportSubmittingParty, _that.getReportSubmittingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingParty != null ? reportingParty.hashCode() : 0);
			_result = 31 * _result + (reportingCounterparty != null ? reportingCounterparty.hashCode() : 0);
			_result = 31 * _result + (partyResponsibleForReporting != null ? partyResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingParty != null ? reportSubmittingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingSideBuilder {" +
				"reportingParty=" + this.reportingParty + ", " +
				"reportingCounterparty=" + this.reportingCounterparty + ", " +
				"partyResponsibleForReporting=" + this.partyResponsibleForReporting + ", " +
				"reportSubmittingParty=" + this.reportSubmittingParty +
			'}';
		}
	}
}
