package drr.regulation.common;

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
import drr.regulation.common.meta.JurisdictionPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies jurisdiction-specific information regarding one party.
 * @version 7.7.0
 */
@RosettaDataType(value="JurisdictionPartyInformation", builder=JurisdictionPartyInformation.JurisdictionPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="JurisdictionPartyInformation", model="drr", builder=JurisdictionPartyInformation.JurisdictionPartyInformationBuilderImpl.class, version="7.7.0")
public interface JurisdictionPartyInformation extends RosettaModelObject {

	JurisdictionPartyInformationMeta metaData = new JurisdictionPartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the party that is associated with the enriched information.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * Indicator of whether the transaction is mandatorily clearable.
	 */
	MandatorilyClearableEnum getMandatorilyClearable();
	/**
	 * Identifies the type of clearing exception or exemption that the counterparty has elected.
	 */
	ClearingException getClearingException();
	/**
	 * Indication of whether the transaction satisfies the definition of &#39;post-priced swap&#39;.
	 */
	Boolean getPostPricedIndicator();
	/**
	 * Party information required for reporting a transaction to the ASIC.
	 */
	ASICPartyInformation getAsicPartyInformation();
	/**
	 * Party information required for reporting a transaction to the CFTC.
	 */
	CFTCPartyInformation getCftcPartyInformation();
	/**
	 * Party information required for reporting a transaction to the CSA.
	 */
	CSAPartyInformation getCsaPartyInformation();
	/**
	 * Party information required for reporting a transaction under SEC.
	 */
	SECPartyInformation getSecPartyInformation();
	/**
	 * Party information required for reporting a transaction under ESMA.
	 */
	ESMAPartyInformation getEsmaPartyInformation();
	/**
	 * Party information required for reporting a transaction under FCA.
	 */
	FCAPartyInformation getFcaPartyInformation();
	/**
	 * Party information required for reporting a transaction to the HKMA.
	 */
	HKMAPartyInformation getHkmaPartyInformation();
	/**
	 * Specifies the reporting role of the party with respect to the regime.
	 */
	ReportingRoleEnum getReportingRole();
	/**
	 * Specifies the Trading Capacity of the specified person with respect to the regime.
	 */
	ReportingRoleEnum getTradingCapacity();
	/**
	 * Provides the unique technical identification of the original data for which the status is provided for the BDR.
	 */
	TechnicalRecordId getTechnicalRecordId();

	/*********************** Build Methods  ***********************/
	JurisdictionPartyInformation build();
	
	JurisdictionPartyInformation.JurisdictionPartyInformationBuilder toBuilder();
	
	static JurisdictionPartyInformation.JurisdictionPartyInformationBuilder builder() {
		return new JurisdictionPartyInformation.JurisdictionPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends JurisdictionPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends JurisdictionPartyInformation> getType() {
		return JurisdictionPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processor.processBasic(path.newSubPath("mandatorilyClearable"), MandatorilyClearableEnum.class, getMandatorilyClearable(), this);
		processRosetta(path.newSubPath("clearingException"), processor, ClearingException.class, getClearingException());
		processor.processBasic(path.newSubPath("postPricedIndicator"), Boolean.class, getPostPricedIndicator(), this);
		processRosetta(path.newSubPath("asicPartyInformation"), processor, ASICPartyInformation.class, getAsicPartyInformation());
		processRosetta(path.newSubPath("cftcPartyInformation"), processor, CFTCPartyInformation.class, getCftcPartyInformation());
		processRosetta(path.newSubPath("csaPartyInformation"), processor, CSAPartyInformation.class, getCsaPartyInformation());
		processRosetta(path.newSubPath("secPartyInformation"), processor, SECPartyInformation.class, getSecPartyInformation());
		processRosetta(path.newSubPath("esmaPartyInformation"), processor, ESMAPartyInformation.class, getEsmaPartyInformation());
		processRosetta(path.newSubPath("fcaPartyInformation"), processor, FCAPartyInformation.class, getFcaPartyInformation());
		processRosetta(path.newSubPath("hkmaPartyInformation"), processor, HKMAPartyInformation.class, getHkmaPartyInformation());
		processor.processBasic(path.newSubPath("reportingRole"), ReportingRoleEnum.class, getReportingRole(), this);
		processor.processBasic(path.newSubPath("tradingCapacity"), ReportingRoleEnum.class, getTradingCapacity(), this);
		processRosetta(path.newSubPath("technicalRecordId"), processor, TechnicalRecordId.class, getTechnicalRecordId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface JurisdictionPartyInformationBuilder extends JurisdictionPartyInformation, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyReference();
		ClearingException.ClearingExceptionBuilder getOrCreateClearingException();
		@Override
		ClearingException.ClearingExceptionBuilder getClearingException();
		ASICPartyInformation.ASICPartyInformationBuilder getOrCreateAsicPartyInformation();
		@Override
		ASICPartyInformation.ASICPartyInformationBuilder getAsicPartyInformation();
		CFTCPartyInformation.CFTCPartyInformationBuilder getOrCreateCftcPartyInformation();
		@Override
		CFTCPartyInformation.CFTCPartyInformationBuilder getCftcPartyInformation();
		CSAPartyInformation.CSAPartyInformationBuilder getOrCreateCsaPartyInformation();
		@Override
		CSAPartyInformation.CSAPartyInformationBuilder getCsaPartyInformation();
		SECPartyInformation.SECPartyInformationBuilder getOrCreateSecPartyInformation();
		@Override
		SECPartyInformation.SECPartyInformationBuilder getSecPartyInformation();
		ESMAPartyInformation.ESMAPartyInformationBuilder getOrCreateEsmaPartyInformation();
		@Override
		ESMAPartyInformation.ESMAPartyInformationBuilder getEsmaPartyInformation();
		FCAPartyInformation.FCAPartyInformationBuilder getOrCreateFcaPartyInformation();
		@Override
		FCAPartyInformation.FCAPartyInformationBuilder getFcaPartyInformation();
		HKMAPartyInformation.HKMAPartyInformationBuilder getOrCreateHkmaPartyInformation();
		@Override
		HKMAPartyInformation.HKMAPartyInformationBuilder getHkmaPartyInformation();
		TechnicalRecordId.TechnicalRecordIdBuilder getOrCreateTechnicalRecordId();
		@Override
		TechnicalRecordId.TechnicalRecordIdBuilder getTechnicalRecordId();
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setPartyReferenceValue(Party partyReference);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setMandatorilyClearable(MandatorilyClearableEnum mandatorilyClearable);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setClearingException(ClearingException clearingException);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setPostPricedIndicator(Boolean postPricedIndicator);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setAsicPartyInformation(ASICPartyInformation asicPartyInformation);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setCftcPartyInformation(CFTCPartyInformation cftcPartyInformation);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setCsaPartyInformation(CSAPartyInformation csaPartyInformation);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setSecPartyInformation(SECPartyInformation secPartyInformation);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setEsmaPartyInformation(ESMAPartyInformation esmaPartyInformation);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setFcaPartyInformation(FCAPartyInformation fcaPartyInformation);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setHkmaPartyInformation(HKMAPartyInformation hkmaPartyInformation);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setReportingRole(ReportingRoleEnum reportingRole);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setTradingCapacity(ReportingRoleEnum tradingCapacity);
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setTechnicalRecordId(TechnicalRecordId technicalRecordId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processor.processBasic(path.newSubPath("mandatorilyClearable"), MandatorilyClearableEnum.class, getMandatorilyClearable(), this);
			processRosetta(path.newSubPath("clearingException"), processor, ClearingException.ClearingExceptionBuilder.class, getClearingException());
			processor.processBasic(path.newSubPath("postPricedIndicator"), Boolean.class, getPostPricedIndicator(), this);
			processRosetta(path.newSubPath("asicPartyInformation"), processor, ASICPartyInformation.ASICPartyInformationBuilder.class, getAsicPartyInformation());
			processRosetta(path.newSubPath("cftcPartyInformation"), processor, CFTCPartyInformation.CFTCPartyInformationBuilder.class, getCftcPartyInformation());
			processRosetta(path.newSubPath("csaPartyInformation"), processor, CSAPartyInformation.CSAPartyInformationBuilder.class, getCsaPartyInformation());
			processRosetta(path.newSubPath("secPartyInformation"), processor, SECPartyInformation.SECPartyInformationBuilder.class, getSecPartyInformation());
			processRosetta(path.newSubPath("esmaPartyInformation"), processor, ESMAPartyInformation.ESMAPartyInformationBuilder.class, getEsmaPartyInformation());
			processRosetta(path.newSubPath("fcaPartyInformation"), processor, FCAPartyInformation.FCAPartyInformationBuilder.class, getFcaPartyInformation());
			processRosetta(path.newSubPath("hkmaPartyInformation"), processor, HKMAPartyInformation.HKMAPartyInformationBuilder.class, getHkmaPartyInformation());
			processor.processBasic(path.newSubPath("reportingRole"), ReportingRoleEnum.class, getReportingRole(), this);
			processor.processBasic(path.newSubPath("tradingCapacity"), ReportingRoleEnum.class, getTradingCapacity(), this);
			processRosetta(path.newSubPath("technicalRecordId"), processor, TechnicalRecordId.TechnicalRecordIdBuilder.class, getTechnicalRecordId());
		}
		

		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of JurisdictionPartyInformation  ***********************/
	class JurisdictionPartyInformationImpl implements JurisdictionPartyInformation {
		private final ReferenceWithMetaParty partyReference;
		private final MandatorilyClearableEnum mandatorilyClearable;
		private final ClearingException clearingException;
		private final Boolean postPricedIndicator;
		private final ASICPartyInformation asicPartyInformation;
		private final CFTCPartyInformation cftcPartyInformation;
		private final CSAPartyInformation csaPartyInformation;
		private final SECPartyInformation secPartyInformation;
		private final ESMAPartyInformation esmaPartyInformation;
		private final FCAPartyInformation fcaPartyInformation;
		private final HKMAPartyInformation hkmaPartyInformation;
		private final ReportingRoleEnum reportingRole;
		private final ReportingRoleEnum tradingCapacity;
		private final TechnicalRecordId technicalRecordId;
		
		protected JurisdictionPartyInformationImpl(JurisdictionPartyInformation.JurisdictionPartyInformationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.mandatorilyClearable = builder.getMandatorilyClearable();
			this.clearingException = ofNullable(builder.getClearingException()).map(f->f.build()).orElse(null);
			this.postPricedIndicator = builder.getPostPricedIndicator();
			this.asicPartyInformation = ofNullable(builder.getAsicPartyInformation()).map(f->f.build()).orElse(null);
			this.cftcPartyInformation = ofNullable(builder.getCftcPartyInformation()).map(f->f.build()).orElse(null);
			this.csaPartyInformation = ofNullable(builder.getCsaPartyInformation()).map(f->f.build()).orElse(null);
			this.secPartyInformation = ofNullable(builder.getSecPartyInformation()).map(f->f.build()).orElse(null);
			this.esmaPartyInformation = ofNullable(builder.getEsmaPartyInformation()).map(f->f.build()).orElse(null);
			this.fcaPartyInformation = ofNullable(builder.getFcaPartyInformation()).map(f->f.build()).orElse(null);
			this.hkmaPartyInformation = ofNullable(builder.getHkmaPartyInformation()).map(f->f.build()).orElse(null);
			this.reportingRole = builder.getReportingRole();
			this.tradingCapacity = builder.getTradingCapacity();
			this.technicalRecordId = ofNullable(builder.getTechnicalRecordId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatorilyClearable")
		public MandatorilyClearableEnum getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("clearingException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingException")
		public ClearingException getClearingException() {
			return clearingException;
		}
		
		@Override
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postPricedIndicator")
		public Boolean getPostPricedIndicator() {
			return postPricedIndicator;
		}
		
		@Override
		@RosettaAttribute("asicPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asicPartyInformation")
		public ASICPartyInformation getAsicPartyInformation() {
			return asicPartyInformation;
		}
		
		@Override
		@RosettaAttribute("cftcPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftcPartyInformation")
		public CFTCPartyInformation getCftcPartyInformation() {
			return cftcPartyInformation;
		}
		
		@Override
		@RosettaAttribute("csaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csaPartyInformation")
		public CSAPartyInformation getCsaPartyInformation() {
			return csaPartyInformation;
		}
		
		@Override
		@RosettaAttribute("secPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secPartyInformation")
		public SECPartyInformation getSecPartyInformation() {
			return secPartyInformation;
		}
		
		@Override
		@RosettaAttribute("esmaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esmaPartyInformation")
		public ESMAPartyInformation getEsmaPartyInformation() {
			return esmaPartyInformation;
		}
		
		@Override
		@RosettaAttribute("fcaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fcaPartyInformation")
		public FCAPartyInformation getFcaPartyInformation() {
			return fcaPartyInformation;
		}
		
		@Override
		@RosettaAttribute("hkmaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hkmaPartyInformation")
		public HKMAPartyInformation getHkmaPartyInformation() {
			return hkmaPartyInformation;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRoleEnum getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingCapacity")
		public ReportingRoleEnum getTradingCapacity() {
			return tradingCapacity;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public TechnicalRecordId getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		public JurisdictionPartyInformation build() {
			return this;
		}
		
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder toBuilder() {
			JurisdictionPartyInformation.JurisdictionPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(JurisdictionPartyInformation.JurisdictionPartyInformationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getMandatorilyClearable()).ifPresent(builder::setMandatorilyClearable);
			ofNullable(getClearingException()).ifPresent(builder::setClearingException);
			ofNullable(getPostPricedIndicator()).ifPresent(builder::setPostPricedIndicator);
			ofNullable(getAsicPartyInformation()).ifPresent(builder::setAsicPartyInformation);
			ofNullable(getCftcPartyInformation()).ifPresent(builder::setCftcPartyInformation);
			ofNullable(getCsaPartyInformation()).ifPresent(builder::setCsaPartyInformation);
			ofNullable(getSecPartyInformation()).ifPresent(builder::setSecPartyInformation);
			ofNullable(getEsmaPartyInformation()).ifPresent(builder::setEsmaPartyInformation);
			ofNullable(getFcaPartyInformation()).ifPresent(builder::setFcaPartyInformation);
			ofNullable(getHkmaPartyInformation()).ifPresent(builder::setHkmaPartyInformation);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getTradingCapacity()).ifPresent(builder::setTradingCapacity);
			ofNullable(getTechnicalRecordId()).ifPresent(builder::setTechnicalRecordId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JurisdictionPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(clearingException, _that.getClearingException())) return false;
			if (!Objects.equals(postPricedIndicator, _that.getPostPricedIndicator())) return false;
			if (!Objects.equals(asicPartyInformation, _that.getAsicPartyInformation())) return false;
			if (!Objects.equals(cftcPartyInformation, _that.getCftcPartyInformation())) return false;
			if (!Objects.equals(csaPartyInformation, _that.getCsaPartyInformation())) return false;
			if (!Objects.equals(secPartyInformation, _that.getSecPartyInformation())) return false;
			if (!Objects.equals(esmaPartyInformation, _that.getEsmaPartyInformation())) return false;
			if (!Objects.equals(fcaPartyInformation, _that.getFcaPartyInformation())) return false;
			if (!Objects.equals(hkmaPartyInformation, _that.getHkmaPartyInformation())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!Objects.equals(tradingCapacity, _that.getTradingCapacity())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingException != null ? clearingException.hashCode() : 0);
			_result = 31 * _result + (postPricedIndicator != null ? postPricedIndicator.hashCode() : 0);
			_result = 31 * _result + (asicPartyInformation != null ? asicPartyInformation.hashCode() : 0);
			_result = 31 * _result + (cftcPartyInformation != null ? cftcPartyInformation.hashCode() : 0);
			_result = 31 * _result + (csaPartyInformation != null ? csaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (secPartyInformation != null ? secPartyInformation.hashCode() : 0);
			_result = 31 * _result + (esmaPartyInformation != null ? esmaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (fcaPartyInformation != null ? fcaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (hkmaPartyInformation != null ? hkmaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradingCapacity != null ? tradingCapacity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JurisdictionPartyInformation {" +
				"partyReference=" + this.partyReference + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"clearingException=" + this.clearingException + ", " +
				"postPricedIndicator=" + this.postPricedIndicator + ", " +
				"asicPartyInformation=" + this.asicPartyInformation + ", " +
				"cftcPartyInformation=" + this.cftcPartyInformation + ", " +
				"csaPartyInformation=" + this.csaPartyInformation + ", " +
				"secPartyInformation=" + this.secPartyInformation + ", " +
				"esmaPartyInformation=" + this.esmaPartyInformation + ", " +
				"fcaPartyInformation=" + this.fcaPartyInformation + ", " +
				"hkmaPartyInformation=" + this.hkmaPartyInformation + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"tradingCapacity=" + this.tradingCapacity + ", " +
				"technicalRecordId=" + this.technicalRecordId +
			'}';
		}
	}

	/*********************** Builder Implementation of JurisdictionPartyInformation  ***********************/
	class JurisdictionPartyInformationBuilderImpl implements JurisdictionPartyInformation.JurisdictionPartyInformationBuilder {
	
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference;
		protected MandatorilyClearableEnum mandatorilyClearable;
		protected ClearingException.ClearingExceptionBuilder clearingException;
		protected Boolean postPricedIndicator;
		protected ASICPartyInformation.ASICPartyInformationBuilder asicPartyInformation;
		protected CFTCPartyInformation.CFTCPartyInformationBuilder cftcPartyInformation;
		protected CSAPartyInformation.CSAPartyInformationBuilder csaPartyInformation;
		protected SECPartyInformation.SECPartyInformationBuilder secPartyInformation;
		protected ESMAPartyInformation.ESMAPartyInformationBuilder esmaPartyInformation;
		protected FCAPartyInformation.FCAPartyInformationBuilder fcaPartyInformation;
		protected HKMAPartyInformation.HKMAPartyInformationBuilder hkmaPartyInformation;
		protected ReportingRoleEnum reportingRole;
		protected ReportingRoleEnum tradingCapacity;
		protected TechnicalRecordId.TechnicalRecordIdBuilder technicalRecordId;
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatorilyClearable")
		public MandatorilyClearableEnum getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("clearingException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingException")
		public ClearingException.ClearingExceptionBuilder getClearingException() {
			return clearingException;
		}
		
		@Override
		public ClearingException.ClearingExceptionBuilder getOrCreateClearingException() {
			ClearingException.ClearingExceptionBuilder result;
			if (clearingException!=null) {
				result = clearingException;
			}
			else {
				result = clearingException = ClearingException.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postPricedIndicator")
		public Boolean getPostPricedIndicator() {
			return postPricedIndicator;
		}
		
		@Override
		@RosettaAttribute("asicPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asicPartyInformation")
		public ASICPartyInformation.ASICPartyInformationBuilder getAsicPartyInformation() {
			return asicPartyInformation;
		}
		
		@Override
		public ASICPartyInformation.ASICPartyInformationBuilder getOrCreateAsicPartyInformation() {
			ASICPartyInformation.ASICPartyInformationBuilder result;
			if (asicPartyInformation!=null) {
				result = asicPartyInformation;
			}
			else {
				result = asicPartyInformation = ASICPartyInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cftcPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftcPartyInformation")
		public CFTCPartyInformation.CFTCPartyInformationBuilder getCftcPartyInformation() {
			return cftcPartyInformation;
		}
		
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder getOrCreateCftcPartyInformation() {
			CFTCPartyInformation.CFTCPartyInformationBuilder result;
			if (cftcPartyInformation!=null) {
				result = cftcPartyInformation;
			}
			else {
				result = cftcPartyInformation = CFTCPartyInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("csaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csaPartyInformation")
		public CSAPartyInformation.CSAPartyInformationBuilder getCsaPartyInformation() {
			return csaPartyInformation;
		}
		
		@Override
		public CSAPartyInformation.CSAPartyInformationBuilder getOrCreateCsaPartyInformation() {
			CSAPartyInformation.CSAPartyInformationBuilder result;
			if (csaPartyInformation!=null) {
				result = csaPartyInformation;
			}
			else {
				result = csaPartyInformation = CSAPartyInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secPartyInformation")
		public SECPartyInformation.SECPartyInformationBuilder getSecPartyInformation() {
			return secPartyInformation;
		}
		
		@Override
		public SECPartyInformation.SECPartyInformationBuilder getOrCreateSecPartyInformation() {
			SECPartyInformation.SECPartyInformationBuilder result;
			if (secPartyInformation!=null) {
				result = secPartyInformation;
			}
			else {
				result = secPartyInformation = SECPartyInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esmaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esmaPartyInformation")
		public ESMAPartyInformation.ESMAPartyInformationBuilder getEsmaPartyInformation() {
			return esmaPartyInformation;
		}
		
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder getOrCreateEsmaPartyInformation() {
			ESMAPartyInformation.ESMAPartyInformationBuilder result;
			if (esmaPartyInformation!=null) {
				result = esmaPartyInformation;
			}
			else {
				result = esmaPartyInformation = ESMAPartyInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fcaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fcaPartyInformation")
		public FCAPartyInformation.FCAPartyInformationBuilder getFcaPartyInformation() {
			return fcaPartyInformation;
		}
		
		@Override
		public FCAPartyInformation.FCAPartyInformationBuilder getOrCreateFcaPartyInformation() {
			FCAPartyInformation.FCAPartyInformationBuilder result;
			if (fcaPartyInformation!=null) {
				result = fcaPartyInformation;
			}
			else {
				result = fcaPartyInformation = FCAPartyInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("hkmaPartyInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hkmaPartyInformation")
		public HKMAPartyInformation.HKMAPartyInformationBuilder getHkmaPartyInformation() {
			return hkmaPartyInformation;
		}
		
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder getOrCreateHkmaPartyInformation() {
			HKMAPartyInformation.HKMAPartyInformationBuilder result;
			if (hkmaPartyInformation!=null) {
				result = hkmaPartyInformation;
			}
			else {
				result = hkmaPartyInformation = HKMAPartyInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRoleEnum getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingCapacity")
		public ReportingRoleEnum getTradingCapacity() {
			return tradingCapacity;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public TechnicalRecordId.TechnicalRecordIdBuilder getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder getOrCreateTechnicalRecordId() {
			TechnicalRecordId.TechnicalRecordIdBuilder result;
			if (technicalRecordId!=null) {
				result = technicalRecordId;
			}
			else {
				result = technicalRecordId = TechnicalRecordId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setPartyReference(ReferenceWithMetaParty _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setPartyReferenceValue(Party _partyReference) {
			this.getOrCreatePartyReference().setValue(_partyReference);
			return this;
		}
		
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatorilyClearable")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setMandatorilyClearable(MandatorilyClearableEnum _mandatorilyClearable) {
			this.mandatorilyClearable = _mandatorilyClearable == null ? null : _mandatorilyClearable;
			return this;
		}
		
		@RosettaAttribute("clearingException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingException")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setClearingException(ClearingException _clearingException) {
			this.clearingException = _clearingException == null ? null : _clearingException.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postPricedIndicator")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setPostPricedIndicator(Boolean _postPricedIndicator) {
			this.postPricedIndicator = _postPricedIndicator == null ? null : _postPricedIndicator;
			return this;
		}
		
		@RosettaAttribute("asicPartyInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asicPartyInformation")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setAsicPartyInformation(ASICPartyInformation _asicPartyInformation) {
			this.asicPartyInformation = _asicPartyInformation == null ? null : _asicPartyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cftcPartyInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cftcPartyInformation")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setCftcPartyInformation(CFTCPartyInformation _cftcPartyInformation) {
			this.cftcPartyInformation = _cftcPartyInformation == null ? null : _cftcPartyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("csaPartyInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("csaPartyInformation")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setCsaPartyInformation(CSAPartyInformation _csaPartyInformation) {
			this.csaPartyInformation = _csaPartyInformation == null ? null : _csaPartyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secPartyInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secPartyInformation")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setSecPartyInformation(SECPartyInformation _secPartyInformation) {
			this.secPartyInformation = _secPartyInformation == null ? null : _secPartyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esmaPartyInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esmaPartyInformation")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setEsmaPartyInformation(ESMAPartyInformation _esmaPartyInformation) {
			this.esmaPartyInformation = _esmaPartyInformation == null ? null : _esmaPartyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fcaPartyInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fcaPartyInformation")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setFcaPartyInformation(FCAPartyInformation _fcaPartyInformation) {
			this.fcaPartyInformation = _fcaPartyInformation == null ? null : _fcaPartyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("hkmaPartyInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hkmaPartyInformation")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setHkmaPartyInformation(HKMAPartyInformation _hkmaPartyInformation) {
			this.hkmaPartyInformation = _hkmaPartyInformation == null ? null : _hkmaPartyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setReportingRole(ReportingRoleEnum _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole;
			return this;
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setTradingCapacity(ReportingRoleEnum _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder setTechnicalRecordId(TechnicalRecordId _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId.toBuilder();
			return this;
		}
		
		@Override
		public JurisdictionPartyInformation build() {
			return new JurisdictionPartyInformation.JurisdictionPartyInformationImpl(this);
		}
		
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (clearingException!=null && !clearingException.prune().hasData()) clearingException = null;
			if (asicPartyInformation!=null && !asicPartyInformation.prune().hasData()) asicPartyInformation = null;
			if (cftcPartyInformation!=null && !cftcPartyInformation.prune().hasData()) cftcPartyInformation = null;
			if (csaPartyInformation!=null && !csaPartyInformation.prune().hasData()) csaPartyInformation = null;
			if (secPartyInformation!=null && !secPartyInformation.prune().hasData()) secPartyInformation = null;
			if (esmaPartyInformation!=null && !esmaPartyInformation.prune().hasData()) esmaPartyInformation = null;
			if (fcaPartyInformation!=null && !fcaPartyInformation.prune().hasData()) fcaPartyInformation = null;
			if (hkmaPartyInformation!=null && !hkmaPartyInformation.prune().hasData()) hkmaPartyInformation = null;
			if (technicalRecordId!=null && !technicalRecordId.prune().hasData()) technicalRecordId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getMandatorilyClearable()!=null) return true;
			if (getClearingException()!=null && getClearingException().hasData()) return true;
			if (getPostPricedIndicator()!=null) return true;
			if (getAsicPartyInformation()!=null && getAsicPartyInformation().hasData()) return true;
			if (getCftcPartyInformation()!=null && getCftcPartyInformation().hasData()) return true;
			if (getCsaPartyInformation()!=null && getCsaPartyInformation().hasData()) return true;
			if (getSecPartyInformation()!=null && getSecPartyInformation().hasData()) return true;
			if (getEsmaPartyInformation()!=null && getEsmaPartyInformation().hasData()) return true;
			if (getFcaPartyInformation()!=null && getFcaPartyInformation().hasData()) return true;
			if (getHkmaPartyInformation()!=null && getHkmaPartyInformation().hasData()) return true;
			if (getReportingRole()!=null) return true;
			if (getTradingCapacity()!=null) return true;
			if (getTechnicalRecordId()!=null && getTechnicalRecordId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			JurisdictionPartyInformation.JurisdictionPartyInformationBuilder o = (JurisdictionPartyInformation.JurisdictionPartyInformationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getClearingException(), o.getClearingException(), this::setClearingException);
			merger.mergeRosetta(getAsicPartyInformation(), o.getAsicPartyInformation(), this::setAsicPartyInformation);
			merger.mergeRosetta(getCftcPartyInformation(), o.getCftcPartyInformation(), this::setCftcPartyInformation);
			merger.mergeRosetta(getCsaPartyInformation(), o.getCsaPartyInformation(), this::setCsaPartyInformation);
			merger.mergeRosetta(getSecPartyInformation(), o.getSecPartyInformation(), this::setSecPartyInformation);
			merger.mergeRosetta(getEsmaPartyInformation(), o.getEsmaPartyInformation(), this::setEsmaPartyInformation);
			merger.mergeRosetta(getFcaPartyInformation(), o.getFcaPartyInformation(), this::setFcaPartyInformation);
			merger.mergeRosetta(getHkmaPartyInformation(), o.getHkmaPartyInformation(), this::setHkmaPartyInformation);
			merger.mergeRosetta(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			
			merger.mergeBasic(getMandatorilyClearable(), o.getMandatorilyClearable(), this::setMandatorilyClearable);
			merger.mergeBasic(getPostPricedIndicator(), o.getPostPricedIndicator(), this::setPostPricedIndicator);
			merger.mergeBasic(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeBasic(getTradingCapacity(), o.getTradingCapacity(), this::setTradingCapacity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JurisdictionPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(clearingException, _that.getClearingException())) return false;
			if (!Objects.equals(postPricedIndicator, _that.getPostPricedIndicator())) return false;
			if (!Objects.equals(asicPartyInformation, _that.getAsicPartyInformation())) return false;
			if (!Objects.equals(cftcPartyInformation, _that.getCftcPartyInformation())) return false;
			if (!Objects.equals(csaPartyInformation, _that.getCsaPartyInformation())) return false;
			if (!Objects.equals(secPartyInformation, _that.getSecPartyInformation())) return false;
			if (!Objects.equals(esmaPartyInformation, _that.getEsmaPartyInformation())) return false;
			if (!Objects.equals(fcaPartyInformation, _that.getFcaPartyInformation())) return false;
			if (!Objects.equals(hkmaPartyInformation, _that.getHkmaPartyInformation())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!Objects.equals(tradingCapacity, _that.getTradingCapacity())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingException != null ? clearingException.hashCode() : 0);
			_result = 31 * _result + (postPricedIndicator != null ? postPricedIndicator.hashCode() : 0);
			_result = 31 * _result + (asicPartyInformation != null ? asicPartyInformation.hashCode() : 0);
			_result = 31 * _result + (cftcPartyInformation != null ? cftcPartyInformation.hashCode() : 0);
			_result = 31 * _result + (csaPartyInformation != null ? csaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (secPartyInformation != null ? secPartyInformation.hashCode() : 0);
			_result = 31 * _result + (esmaPartyInformation != null ? esmaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (fcaPartyInformation != null ? fcaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (hkmaPartyInformation != null ? hkmaPartyInformation.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradingCapacity != null ? tradingCapacity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JurisdictionPartyInformationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"clearingException=" + this.clearingException + ", " +
				"postPricedIndicator=" + this.postPricedIndicator + ", " +
				"asicPartyInformation=" + this.asicPartyInformation + ", " +
				"cftcPartyInformation=" + this.cftcPartyInformation + ", " +
				"csaPartyInformation=" + this.csaPartyInformation + ", " +
				"secPartyInformation=" + this.secPartyInformation + ", " +
				"esmaPartyInformation=" + this.esmaPartyInformation + ", " +
				"fcaPartyInformation=" + this.fcaPartyInformation + ", " +
				"hkmaPartyInformation=" + this.hkmaPartyInformation + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"tradingCapacity=" + this.tradingCapacity + ", " +
				"technicalRecordId=" + this.technicalRecordId +
			'}';
		}
	}
}
