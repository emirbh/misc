package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.FacilitySummaryMeta;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A short form of a facility.
 *
 */
@RosettaDataType(value="FacilitySummary", builder=FacilitySummary.FacilitySummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilitySummary", model="fpml", builder=FacilitySummary.FacilitySummaryBuilderImpl.class, version="2.1.1")
public interface FacilitySummary extends FacilityIdentifier {

	FacilitySummaryMeta metaData = new FacilitySummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party reference to the (main) borrower. This may be different to the issuer defined at the deal-level.
	 *
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party references to co-borrowers as listed on the credit agreement.
	 *
	 */
	List<? extends PartyReference> getCoBorrowerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party reference to the agent bank. Each facility (within a single deal) can have specific/different agent banks, especially if there are jurisdictional boundaries being crossed.
	 *
	 */
	PartyReference getAgentPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party references to any guarantors associated with the facility borrower.
	 *
	 */
	List<? extends PartyReference> getLcIssuingBankPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party references to any guarantors associated with the facility borrower.
	 *
	 */
	List<? extends PartyReference> getGuarantorPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start date of the facility.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The latest date that a drawdown can be made effective against the facility.
	 *
	 */
	ZonedDateTime getExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maturity date of the facility.
	 *
	 */
	ZonedDateTime getMaturityDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The current global/lender share commitment amount. This defines the current limit against which the borrower may draw funds.
	 *
	 */
	FacilityCommitment getCurrentCommitment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The original global commitment amount. This defines the limit, as of the start date, against which the borrower may draw funds.
	 *
	 */
	MoneyWithParticipantShare getOriginalCommitment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The commitment schedule associated with the facility.
	 *
	 */
	CommitmentSchedule getCommitmentSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the exchange rate between the facility and deal denomination currencies (only required if the currencies are different).
	 *
	 */
	FxTerms getDealFxRate();

	/*********************** Build Methods  ***********************/
	FacilitySummary build();
	
	FacilitySummary.FacilitySummaryBuilder toBuilder();
	
	static FacilitySummary.FacilitySummaryBuilder builder() {
		return new FacilitySummary.FacilitySummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilitySummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilitySummary> getType() {
		return FacilitySummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.class, getCoBorrowerPartyReference());
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.class, getLcIssuingBankPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
		processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.class, getCurrentCommitment());
		processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.class, getOriginalCommitment());
		processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.class, getCommitmentSchedule());
		processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.class, getDealFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilitySummaryBuilder extends FacilitySummary, FacilityIdentifier.FacilityIdentifierBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateCoBorrowerPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getCoBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getAgentPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateLcIssuingBankPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getLcIssuingBankPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference();
		FacilityCommitment.FacilityCommitmentBuilder getOrCreateCurrentCommitment();
		@Override
		FacilityCommitment.FacilityCommitmentBuilder getCurrentCommitment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateOriginalCommitment();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOriginalCommitment();
		CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule();
		@Override
		CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule();
		FxTerms.FxTermsBuilder getOrCreateDealFxRate();
		@Override
		FxTerms.FxTermsBuilder getDealFxRate();
		@Override
		FacilitySummary.FacilitySummaryBuilder setId(String id);
		@Override
		FacilitySummary.FacilitySummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		FacilitySummary.FacilitySummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		FacilitySummary.FacilitySummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		FacilitySummary.FacilitySummaryBuilder setDescription(String description);
		@Override
		FacilitySummary.FacilitySummaryBuilder setDealReference(DealReference dealReference);
		FacilitySummary.FacilitySummaryBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		FacilitySummary.FacilitySummaryBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference);
		FacilitySummary.FacilitySummaryBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference, int idx);
		FacilitySummary.FacilitySummaryBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		FacilitySummary.FacilitySummaryBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		FacilitySummary.FacilitySummaryBuilder setAgentPartyReference(PartyReference agentPartyReference);
		FacilitySummary.FacilitySummaryBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference);
		FacilitySummary.FacilitySummaryBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference, int idx);
		FacilitySummary.FacilitySummaryBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		FacilitySummary.FacilitySummaryBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		FacilitySummary.FacilitySummaryBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		FacilitySummary.FacilitySummaryBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		FacilitySummary.FacilitySummaryBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		FacilitySummary.FacilitySummaryBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		FacilitySummary.FacilitySummaryBuilder setStartDate(ZonedDateTime startDate);
		FacilitySummary.FacilitySummaryBuilder setExpiryDate(ZonedDateTime expiryDate);
		FacilitySummary.FacilitySummaryBuilder setMaturityDate(ZonedDateTime maturityDate);
		FacilitySummary.FacilitySummaryBuilder setCurrentCommitment(FacilityCommitment currentCommitment);
		FacilitySummary.FacilitySummaryBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment);
		FacilitySummary.FacilitySummaryBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);
		FacilitySummary.FacilitySummaryBuilder setDealFxRate(FxTerms dealFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCoBorrowerPartyReference());
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLcIssuingBankPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
			processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getCurrentCommitment());
			processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getOriginalCommitment());
			processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.CommitmentScheduleBuilder.class, getCommitmentSchedule());
			processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.FxTermsBuilder.class, getDealFxRate());
		}
		

		FacilitySummary.FacilitySummaryBuilder prune();
	}

	/*********************** Immutable Implementation of FacilitySummary  ***********************/
	class FacilitySummaryImpl extends FacilityIdentifier.FacilityIdentifierImpl implements FacilitySummary {
		private final PartyReference borrowerPartyReference;
		private final List<? extends PartyReference> coBorrowerPartyReference;
		private final PartyReference agentPartyReference;
		private final List<? extends PartyReference> lcIssuingBankPartyReference;
		private final List<? extends PartyReference> guarantorPartyReference;
		private final ZonedDateTime startDate;
		private final ZonedDateTime expiryDate;
		private final ZonedDateTime maturityDate;
		private final FacilityCommitment currentCommitment;
		private final MoneyWithParticipantShare originalCommitment;
		private final CommitmentSchedule commitmentSchedule;
		private final FxTerms dealFxRate;
		
		protected FacilitySummaryImpl(FacilitySummary.FacilitySummaryBuilder builder) {
			super(builder);
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.coBorrowerPartyReference = ofNullable(builder.getCoBorrowerPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.agentPartyReference = ofNullable(builder.getAgentPartyReference()).map(f->f.build()).orElse(null);
			this.lcIssuingBankPartyReference = ofNullable(builder.getLcIssuingBankPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.guarantorPartyReference = ofNullable(builder.getGuarantorPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.startDate = builder.getStartDate();
			this.expiryDate = builder.getExpiryDate();
			this.maturityDate = builder.getMaturityDate();
			this.currentCommitment = ofNullable(builder.getCurrentCommitment()).map(f->f.build()).orElse(null);
			this.originalCommitment = ofNullable(builder.getOriginalCommitment()).map(f->f.build()).orElse(null);
			this.commitmentSchedule = ofNullable(builder.getCommitmentSchedule()).map(f->f.build()).orElse(null);
			this.dealFxRate = ofNullable(builder.getDealFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		public List<? extends PartyReference> getCoBorrowerPartyReference() {
			return coBorrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agentPartyReference")
		public PartyReference getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		public List<? extends PartyReference> getLcIssuingBankPartyReference() {
			return lcIssuingBankPartyReference;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		public List<? extends PartyReference> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentCommitment")
		public FacilityCommitment getCurrentCommitment() {
			return currentCommitment;
		}
		
		@Override
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalCommitment")
		public MoneyWithParticipantShare getOriginalCommitment() {
			return originalCommitment;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commitmentSchedule")
		public CommitmentSchedule getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealFxRate")
		public FxTerms getDealFxRate() {
			return dealFxRate;
		}
		
		@Override
		public FacilitySummary build() {
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder toBuilder() {
			FacilitySummary.FacilitySummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilitySummary.FacilitySummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getCoBorrowerPartyReference()).ifPresent(builder::setCoBorrowerPartyReference);
			ofNullable(getAgentPartyReference()).ifPresent(builder::setAgentPartyReference);
			ofNullable(getLcIssuingBankPartyReference()).ifPresent(builder::setLcIssuingBankPartyReference);
			ofNullable(getGuarantorPartyReference()).ifPresent(builder::setGuarantorPartyReference);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
			ofNullable(getCurrentCommitment()).ifPresent(builder::setCurrentCommitment);
			ofNullable(getOriginalCommitment()).ifPresent(builder::setOriginalCommitment);
			ofNullable(getCommitmentSchedule()).ifPresent(builder::setCommitmentSchedule);
			ofNullable(getDealFxRate()).ifPresent(builder::setDealFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilitySummary _that = getType().cast(o);
		
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!ListEquals.listEquals(coBorrowerPartyReference, _that.getCoBorrowerPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!ListEquals.listEquals(lcIssuingBankPartyReference, _that.getLcIssuingBankPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(currentCommitment, _that.getCurrentCommitment())) return false;
			if (!Objects.equals(originalCommitment, _that.getOriginalCommitment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			if (!Objects.equals(dealFxRate, _that.getDealFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (coBorrowerPartyReference != null ? coBorrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (lcIssuingBankPartyReference != null ? lcIssuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (currentCommitment != null ? currentCommitment.hashCode() : 0);
			_result = 31 * _result + (originalCommitment != null ? originalCommitment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			_result = 31 * _result + (dealFxRate != null ? dealFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilitySummary {" +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"coBorrowerPartyReference=" + this.coBorrowerPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"lcIssuingBankPartyReference=" + this.lcIssuingBankPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"currentCommitment=" + this.currentCommitment + ", " +
				"originalCommitment=" + this.originalCommitment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule + ", " +
				"dealFxRate=" + this.dealFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilitySummary  ***********************/
	class FacilitySummaryBuilderImpl extends FacilityIdentifier.FacilityIdentifierBuilderImpl implements FacilitySummary.FacilitySummaryBuilder {
	
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> coBorrowerPartyReference = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder agentPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> lcIssuingBankPartyReference = new ArrayList<>();
		protected List<PartyReference.PartyReferenceBuilder> guarantorPartyReference = new ArrayList<>();
		protected ZonedDateTime startDate;
		protected ZonedDateTime expiryDate;
		protected ZonedDateTime maturityDate;
		protected FacilityCommitment.FacilityCommitmentBuilder currentCommitment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder originalCommitment;
		protected CommitmentSchedule.CommitmentScheduleBuilder commitmentSchedule;
		protected FxTerms.FxTermsBuilder dealFxRate;
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		public PartyReference.PartyReferenceBuilder getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (borrowerPartyReference!=null) {
				result = borrowerPartyReference;
			}
			else {
				result = borrowerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getCoBorrowerPartyReference() {
			return coBorrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCoBorrowerPartyReference(int index) {
			if (coBorrowerPartyReference==null) {
				this.coBorrowerPartyReference = new ArrayList<>();
			}
			return getIndex(coBorrowerPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newCoBorrowerPartyReference = PartyReference.builder();
						return newCoBorrowerPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agentPartyReference")
		public PartyReference.PartyReferenceBuilder getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (agentPartyReference!=null) {
				result = agentPartyReference;
			}
			else {
				result = agentPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getLcIssuingBankPartyReference() {
			return lcIssuingBankPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateLcIssuingBankPartyReference(int index) {
			if (lcIssuingBankPartyReference==null) {
				this.lcIssuingBankPartyReference = new ArrayList<>();
			}
			return getIndex(lcIssuingBankPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newLcIssuingBankPartyReference = PartyReference.builder();
						return newLcIssuingBankPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference(int index) {
			if (guarantorPartyReference==null) {
				this.guarantorPartyReference = new ArrayList<>();
			}
			return getIndex(guarantorPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newGuarantorPartyReference = PartyReference.builder();
						return newGuarantorPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentCommitment")
		public FacilityCommitment.FacilityCommitmentBuilder getCurrentCommitment() {
			return currentCommitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreateCurrentCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (currentCommitment!=null) {
				result = currentCommitment;
			}
			else {
				result = currentCommitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalCommitment")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOriginalCommitment() {
			return originalCommitment;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateOriginalCommitment() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (originalCommitment!=null) {
				result = originalCommitment;
			}
			else {
				result = originalCommitment = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commitmentSchedule")
		public CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule() {
			CommitmentSchedule.CommitmentScheduleBuilder result;
			if (commitmentSchedule!=null) {
				result = commitmentSchedule;
			}
			else {
				result = commitmentSchedule = CommitmentSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealFxRate")
		public FxTerms.FxTermsBuilder getDealFxRate() {
			return dealFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateDealFxRate() {
			FxTerms.FxTermsBuilder result;
			if (dealFxRate!=null) {
				result = dealFxRate;
			}
			else {
				result = dealFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference) {
			if (_coBorrowerPartyReference != null) {
				this.coBorrowerPartyReference.add(_coBorrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference, int idx) {
			getIndex(this.coBorrowerPartyReference, idx, () -> _coBorrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences != null) {
				for (final PartyReference toAdd : coBorrowerPartyReferences) {
					this.coBorrowerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences == null) {
				this.coBorrowerPartyReference = new ArrayList<>();
			} else {
				this.coBorrowerPartyReference = coBorrowerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference) {
			if (_lcIssuingBankPartyReference != null) {
				this.lcIssuingBankPartyReference.add(_lcIssuingBankPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference, int idx) {
			getIndex(this.lcIssuingBankPartyReference, idx, () -> _lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences != null) {
				for (final PartyReference toAdd : lcIssuingBankPartyReferences) {
					this.lcIssuingBankPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences == null) {
				this.lcIssuingBankPartyReference = new ArrayList<>();
			} else {
				this.lcIssuingBankPartyReference = lcIssuingBankPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences != null) {
				for (final PartyReference toAdd : guarantorPartyReferences) {
					this.guarantorPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences == null) {
				this.guarantorPartyReference = new ArrayList<>();
			} else {
				this.guarantorPartyReference = guarantorPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentCommitment")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setCurrentCommitment(FacilityCommitment _currentCommitment) {
			this.currentCommitment = _currentCommitment == null ? null : _currentCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalCommitment")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setOriginalCommitment(MoneyWithParticipantShare _originalCommitment) {
			this.originalCommitment = _originalCommitment == null ? null : _originalCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentSchedule")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setCommitmentSchedule(CommitmentSchedule _commitmentSchedule) {
			this.commitmentSchedule = _commitmentSchedule == null ? null : _commitmentSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealFxRate")
		@Override
		public FacilitySummary.FacilitySummaryBuilder setDealFxRate(FxTerms _dealFxRate) {
			this.dealFxRate = _dealFxRate == null ? null : _dealFxRate.toBuilder();
			return this;
		}
		
		@Override
		public FacilitySummary build() {
			return new FacilitySummary.FacilitySummaryImpl(this);
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilitySummary.FacilitySummaryBuilder prune() {
			super.prune();
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			coBorrowerPartyReference = coBorrowerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (agentPartyReference!=null && !agentPartyReference.prune().hasData()) agentPartyReference = null;
			lcIssuingBankPartyReference = lcIssuingBankPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			guarantorPartyReference = guarantorPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (currentCommitment!=null && !currentCommitment.prune().hasData()) currentCommitment = null;
			if (originalCommitment!=null && !originalCommitment.prune().hasData()) originalCommitment = null;
			if (commitmentSchedule!=null && !commitmentSchedule.prune().hasData()) commitmentSchedule = null;
			if (dealFxRate!=null && !dealFxRate.prune().hasData()) dealFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getCoBorrowerPartyReference()!=null && getCoBorrowerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAgentPartyReference()!=null && getAgentPartyReference().hasData()) return true;
			if (getLcIssuingBankPartyReference()!=null && getLcIssuingBankPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGuarantorPartyReference()!=null && getGuarantorPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStartDate()!=null) return true;
			if (getExpiryDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			if (getCurrentCommitment()!=null && getCurrentCommitment().hasData()) return true;
			if (getOriginalCommitment()!=null && getOriginalCommitment().hasData()) return true;
			if (getCommitmentSchedule()!=null && getCommitmentSchedule().hasData()) return true;
			if (getDealFxRate()!=null && getDealFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilitySummary.FacilitySummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FacilitySummary.FacilitySummaryBuilder o = (FacilitySummary.FacilitySummaryBuilder) other;
			
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getCoBorrowerPartyReference(), o.getCoBorrowerPartyReference(), this::getOrCreateCoBorrowerPartyReference);
			merger.mergeRosetta(getAgentPartyReference(), o.getAgentPartyReference(), this::setAgentPartyReference);
			merger.mergeRosetta(getLcIssuingBankPartyReference(), o.getLcIssuingBankPartyReference(), this::getOrCreateLcIssuingBankPartyReference);
			merger.mergeRosetta(getGuarantorPartyReference(), o.getGuarantorPartyReference(), this::getOrCreateGuarantorPartyReference);
			merger.mergeRosetta(getCurrentCommitment(), o.getCurrentCommitment(), this::setCurrentCommitment);
			merger.mergeRosetta(getOriginalCommitment(), o.getOriginalCommitment(), this::setOriginalCommitment);
			merger.mergeRosetta(getCommitmentSchedule(), o.getCommitmentSchedule(), this::setCommitmentSchedule);
			merger.mergeRosetta(getDealFxRate(), o.getDealFxRate(), this::setDealFxRate);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilitySummary _that = getType().cast(o);
		
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!ListEquals.listEquals(coBorrowerPartyReference, _that.getCoBorrowerPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!ListEquals.listEquals(lcIssuingBankPartyReference, _that.getLcIssuingBankPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(currentCommitment, _that.getCurrentCommitment())) return false;
			if (!Objects.equals(originalCommitment, _that.getOriginalCommitment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			if (!Objects.equals(dealFxRate, _that.getDealFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (coBorrowerPartyReference != null ? coBorrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (lcIssuingBankPartyReference != null ? lcIssuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (currentCommitment != null ? currentCommitment.hashCode() : 0);
			_result = 31 * _result + (originalCommitment != null ? originalCommitment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			_result = 31 * _result + (dealFxRate != null ? dealFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilitySummaryBuilder {" +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"coBorrowerPartyReference=" + this.coBorrowerPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"lcIssuingBankPartyReference=" + this.lcIssuingBankPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"currentCommitment=" + this.currentCommitment + ", " +
				"originalCommitment=" + this.originalCommitment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule + ", " +
				"dealFxRate=" + this.dealFxRate +
			'}' + " " + super.toString();
		}
	}
}
