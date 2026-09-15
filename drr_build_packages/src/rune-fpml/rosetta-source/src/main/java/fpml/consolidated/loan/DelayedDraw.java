package fpml.consolidated.loan;

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
import fpml.consolidated.asset.Lien;
import fpml.consolidated.loan.meta.DelayedDrawMeta;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.GoverningLaw;
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
 * Provision A facility which can be drawn at any point during a pre-defined period after the initial deal closing date,
 *
 */
@RosettaDataType(value="DelayedDraw", builder=DelayedDraw.DelayedDrawBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DelayedDraw", model="fpml", builder=DelayedDraw.DelayedDrawBuilderImpl.class, version="2.1.1")
public interface DelayedDraw extends AbstractFacility {

	DelayedDrawMeta metaData = new DelayedDrawMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A flag to determine whether the Term Loan has a delayed draw feature.
	 *
	 */
	Boolean getDelayedDraw();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date by which funds must be drawn.
	 *
	 */
	ZonedDateTime getMustDrawByDate();

	/*********************** Build Methods  ***********************/
	DelayedDraw build();
	
	DelayedDraw.DelayedDrawBuilder toBuilder();
	
	static DelayedDraw.DelayedDrawBuilder builder() {
		return new DelayedDraw.DelayedDrawBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DelayedDraw> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DelayedDraw> getType() {
		return DelayedDraw.class;
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
		processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.class, getGoverningLaw());
		processRosetta(path.newSubPath("feature"), processor, FacilityFeature.class, getFeature());
		processRosetta(path.newSubPath("lien"), processor, Lien.class, getLien());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processRosetta(path.newSubPath("abstractFacilityChoice"), processor, AbstractFacilityChoice.class, getAbstractFacilityChoice());
		processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.class, getAccruingPikOption());
		processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.class, getAccruingFeeOption());
		processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.class, getDefaultRate());
		processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.class, getMandatoryCostRate());
		processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.class, getPenaltyRate());
		processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.class, getMultiCurrency());
		processor.processBasic(path.newSubPath("delayedDraw"), Boolean.class, getDelayedDraw(), this);
		processor.processBasic(path.newSubPath("mustDrawByDate"), ZonedDateTime.class, getMustDrawByDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DelayedDrawBuilder extends DelayedDraw, AbstractFacility.AbstractFacilityBuilder {
		@Override
		DelayedDraw.DelayedDrawBuilder setId(String id);
		@Override
		DelayedDraw.DelayedDrawBuilder setPartyReference(PartyReference partyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		DelayedDraw.DelayedDrawBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		DelayedDraw.DelayedDrawBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		DelayedDraw.DelayedDrawBuilder setDescription(String description);
		@Override
		DelayedDraw.DelayedDrawBuilder setDealReference(DealReference dealReference);
		@Override
		DelayedDraw.DelayedDrawBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference, int idx);
		@Override
		DelayedDraw.DelayedDrawBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference, int idx);
		@Override
		DelayedDraw.DelayedDrawBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		@Override
		DelayedDraw.DelayedDrawBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		DelayedDraw.DelayedDrawBuilder setStartDate(ZonedDateTime startDate);
		@Override
		DelayedDraw.DelayedDrawBuilder setExpiryDate(ZonedDateTime expiryDate);
		@Override
		DelayedDraw.DelayedDrawBuilder setMaturityDate(ZonedDateTime maturityDate);
		@Override
		DelayedDraw.DelayedDrawBuilder setCurrentCommitment(FacilityCommitment currentCommitment);
		@Override
		DelayedDraw.DelayedDrawBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment);
		@Override
		DelayedDraw.DelayedDrawBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);
		@Override
		DelayedDraw.DelayedDrawBuilder setDealFxRate(FxTerms dealFxRate);
		@Override
		DelayedDraw.DelayedDrawBuilder setGoverningLaw(GoverningLaw governingLaw);
		@Override
		DelayedDraw.DelayedDrawBuilder addFeature(FacilityFeature feature);
		@Override
		DelayedDraw.DelayedDrawBuilder addFeature(FacilityFeature feature, int idx);
		@Override
		DelayedDraw.DelayedDrawBuilder addFeature(List<? extends FacilityFeature> feature);
		@Override
		DelayedDraw.DelayedDrawBuilder setFeature(List<? extends FacilityFeature> feature);
		@Override
		DelayedDraw.DelayedDrawBuilder setLien(Lien lien);
		@Override
		DelayedDraw.DelayedDrawBuilder setSeniority(CreditSeniority seniority);
		@Override
		DelayedDraw.DelayedDrawBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice);
		@Override
		DelayedDraw.DelayedDrawBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice, int idx);
		@Override
		DelayedDraw.DelayedDrawBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		DelayedDraw.DelayedDrawBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		DelayedDraw.DelayedDrawBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);
		@Override
		DelayedDraw.DelayedDrawBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption);
		@Override
		DelayedDraw.DelayedDrawBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption, int idx);
		@Override
		DelayedDraw.DelayedDrawBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		DelayedDraw.DelayedDrawBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		DelayedDraw.DelayedDrawBuilder setDefaultRate(PeriodRate defaultRate);
		@Override
		DelayedDraw.DelayedDrawBuilder setMandatoryCostRate(PeriodRate mandatoryCostRate);
		@Override
		DelayedDraw.DelayedDrawBuilder setPenaltyRate(PeriodRate penaltyRate);
		@Override
		DelayedDraw.DelayedDrawBuilder setMultiCurrency(MultiCurrency multiCurrency);
		DelayedDraw.DelayedDrawBuilder setDelayedDraw(Boolean delayedDraw);
		DelayedDraw.DelayedDrawBuilder setMustDrawByDate(ZonedDateTime mustDrawByDate);

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
			processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.GoverningLawBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("feature"), processor, FacilityFeature.FacilityFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("lien"), processor, Lien.LienBuilder.class, getLien());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processRosetta(path.newSubPath("abstractFacilityChoice"), processor, AbstractFacilityChoice.AbstractFacilityChoiceBuilder.class, getAbstractFacilityChoice());
			processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.AccruingPikOptionBuilder.class, getAccruingPikOption());
			processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.AccruingFeeOptionBuilder.class, getAccruingFeeOption());
			processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.PeriodRateBuilder.class, getDefaultRate());
			processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.PeriodRateBuilder.class, getMandatoryCostRate());
			processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.PeriodRateBuilder.class, getPenaltyRate());
			processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.MultiCurrencyBuilder.class, getMultiCurrency());
			processor.processBasic(path.newSubPath("delayedDraw"), Boolean.class, getDelayedDraw(), this);
			processor.processBasic(path.newSubPath("mustDrawByDate"), ZonedDateTime.class, getMustDrawByDate(), this);
		}
		

		DelayedDraw.DelayedDrawBuilder prune();
	}

	/*********************** Immutable Implementation of DelayedDraw  ***********************/
	class DelayedDrawImpl extends AbstractFacility.AbstractFacilityImpl implements DelayedDraw {
		private final Boolean delayedDraw;
		private final ZonedDateTime mustDrawByDate;
		
		protected DelayedDrawImpl(DelayedDraw.DelayedDrawBuilder builder) {
			super(builder);
			this.delayedDraw = builder.getDelayedDraw();
			this.mustDrawByDate = builder.getMustDrawByDate();
		}
		
		@Override
		@RosettaAttribute("delayedDraw")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("delayedDraw")
		public Boolean getDelayedDraw() {
			return delayedDraw;
		}
		
		@Override
		@RosettaAttribute("mustDrawByDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mustDrawByDate")
		public ZonedDateTime getMustDrawByDate() {
			return mustDrawByDate;
		}
		
		@Override
		public DelayedDraw build() {
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder toBuilder() {
			DelayedDraw.DelayedDrawBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DelayedDraw.DelayedDrawBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDelayedDraw()).ifPresent(builder::setDelayedDraw);
			ofNullable(getMustDrawByDate()).ifPresent(builder::setMustDrawByDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DelayedDraw _that = getType().cast(o);
		
			if (!Objects.equals(delayedDraw, _that.getDelayedDraw())) return false;
			if (!Objects.equals(mustDrawByDate, _that.getMustDrawByDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (delayedDraw != null ? delayedDraw.hashCode() : 0);
			_result = 31 * _result + (mustDrawByDate != null ? mustDrawByDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DelayedDraw {" +
				"delayedDraw=" + this.delayedDraw + ", " +
				"mustDrawByDate=" + this.mustDrawByDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DelayedDraw  ***********************/
	class DelayedDrawBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl implements DelayedDraw.DelayedDrawBuilder {
	
		protected Boolean delayedDraw;
		protected ZonedDateTime mustDrawByDate;
		
		@Override
		@RosettaAttribute("delayedDraw")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("delayedDraw")
		public Boolean getDelayedDraw() {
			return delayedDraw;
		}
		
		@Override
		@RosettaAttribute("mustDrawByDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mustDrawByDate")
		public ZonedDateTime getMustDrawByDate() {
			return mustDrawByDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DelayedDraw.DelayedDrawBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public DelayedDraw.DelayedDrawBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public DelayedDraw.DelayedDrawBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public DelayedDraw.DelayedDrawBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public DelayedDraw.DelayedDrawBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public DelayedDraw.DelayedDrawBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public DelayedDraw.DelayedDrawBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference) {
			if (_coBorrowerPartyReference != null) {
				this.coBorrowerPartyReference.add(_coBorrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference, int idx) {
			getIndex(this.coBorrowerPartyReference, idx, () -> _coBorrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
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
		public DelayedDraw.DelayedDrawBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
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
		public DelayedDraw.DelayedDrawBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public DelayedDraw.DelayedDrawBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference) {
			if (_lcIssuingBankPartyReference != null) {
				this.lcIssuingBankPartyReference.add(_lcIssuingBankPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference, int idx) {
			getIndex(this.lcIssuingBankPartyReference, idx, () -> _lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
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
		public DelayedDraw.DelayedDrawBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
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
		public DelayedDraw.DelayedDrawBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public DelayedDraw.DelayedDrawBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public DelayedDraw.DelayedDrawBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public DelayedDraw.DelayedDrawBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public DelayedDraw.DelayedDrawBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentCommitment")
		@Override
		public DelayedDraw.DelayedDrawBuilder setCurrentCommitment(FacilityCommitment _currentCommitment) {
			this.currentCommitment = _currentCommitment == null ? null : _currentCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalCommitment")
		@Override
		public DelayedDraw.DelayedDrawBuilder setOriginalCommitment(MoneyWithParticipantShare _originalCommitment) {
			this.originalCommitment = _originalCommitment == null ? null : _originalCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentSchedule")
		@Override
		public DelayedDraw.DelayedDrawBuilder setCommitmentSchedule(CommitmentSchedule _commitmentSchedule) {
			this.commitmentSchedule = _commitmentSchedule == null ? null : _commitmentSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealFxRate")
		@Override
		public DelayedDraw.DelayedDrawBuilder setDealFxRate(FxTerms _dealFxRate) {
			this.dealFxRate = _dealFxRate == null ? null : _dealFxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("governingLaw")
		@Override
		public DelayedDraw.DelayedDrawBuilder setGoverningLaw(GoverningLaw _governingLaw) {
			this.governingLaw = _governingLaw == null ? null : _governingLaw.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public DelayedDraw.DelayedDrawBuilder addFeature(FacilityFeature _feature) {
			if (_feature != null) {
				this.feature.add(_feature.toBuilder());
			}
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addFeature(FacilityFeature _feature, int idx) {
			getIndex(this.feature, idx, () -> _feature.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addFeature(List<? extends FacilityFeature> features) {
			if (features != null) {
				for (final FacilityFeature toAdd : features) {
					this.feature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public DelayedDraw.DelayedDrawBuilder setFeature(List<? extends FacilityFeature> features) {
			if (features == null) {
				this.feature = new ArrayList<>();
			} else {
				this.feature = features.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lien")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lien")
		@Override
		public DelayedDraw.DelayedDrawBuilder setLien(Lien _lien) {
			this.lien = _lien == null ? null : _lien.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public DelayedDraw.DelayedDrawBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public DelayedDraw.DelayedDrawBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice) {
			if (_abstractFacilityChoice != null) {
				this.abstractFacilityChoice.add(_abstractFacilityChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice, int idx) {
			getIndex(this.abstractFacilityChoice, idx, () -> _abstractFacilityChoice.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
			if (abstractFacilityChoices != null) {
				for (final AbstractFacilityChoice toAdd : abstractFacilityChoices) {
					this.abstractFacilityChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public DelayedDraw.DelayedDrawBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
			if (abstractFacilityChoices == null) {
				this.abstractFacilityChoice = new ArrayList<>();
			} else {
				this.abstractFacilityChoice = abstractFacilityChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruingPikOption")
		@Override
		public DelayedDraw.DelayedDrawBuilder setAccruingPikOption(AccruingPikOption _accruingPikOption) {
			this.accruingPikOption = _accruingPikOption == null ? null : _accruingPikOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public DelayedDraw.DelayedDrawBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption) {
			if (_accruingFeeOption != null) {
				this.accruingFeeOption.add(_accruingFeeOption.toBuilder());
			}
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption, int idx) {
			getIndex(this.accruingFeeOption, idx, () -> _accruingFeeOption.toBuilder());
			return this;
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions != null) {
				for (final AccruingFeeOption toAdd : accruingFeeOptions) {
					this.accruingFeeOption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public DelayedDraw.DelayedDrawBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions == null) {
				this.accruingFeeOption = new ArrayList<>();
			} else {
				this.accruingFeeOption = accruingFeeOptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("defaultRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("defaultRate")
		@Override
		public DelayedDraw.DelayedDrawBuilder setDefaultRate(PeriodRate _defaultRate) {
			this.defaultRate = _defaultRate == null ? null : _defaultRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryCostRate")
		@Override
		public DelayedDraw.DelayedDrawBuilder setMandatoryCostRate(PeriodRate _mandatoryCostRate) {
			this.mandatoryCostRate = _mandatoryCostRate == null ? null : _mandatoryCostRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("penaltyRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("penaltyRate")
		@Override
		public DelayedDraw.DelayedDrawBuilder setPenaltyRate(PeriodRate _penaltyRate) {
			this.penaltyRate = _penaltyRate == null ? null : _penaltyRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiCurrency")
		@Override
		public DelayedDraw.DelayedDrawBuilder setMultiCurrency(MultiCurrency _multiCurrency) {
			this.multiCurrency = _multiCurrency == null ? null : _multiCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("delayedDraw")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("delayedDraw")
		@Override
		public DelayedDraw.DelayedDrawBuilder setDelayedDraw(Boolean _delayedDraw) {
			this.delayedDraw = _delayedDraw == null ? null : _delayedDraw;
			return this;
		}
		
		@RosettaAttribute("mustDrawByDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mustDrawByDate")
		@Override
		public DelayedDraw.DelayedDrawBuilder setMustDrawByDate(ZonedDateTime _mustDrawByDate) {
			this.mustDrawByDate = _mustDrawByDate == null ? null : _mustDrawByDate;
			return this;
		}
		
		@Override
		public DelayedDraw build() {
			return new DelayedDraw.DelayedDrawImpl(this);
		}
		
		@Override
		public DelayedDraw.DelayedDrawBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DelayedDraw.DelayedDrawBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDelayedDraw()!=null) return true;
			if (getMustDrawByDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DelayedDraw.DelayedDrawBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DelayedDraw.DelayedDrawBuilder o = (DelayedDraw.DelayedDrawBuilder) other;
			
			
			merger.mergeBasic(getDelayedDraw(), o.getDelayedDraw(), this::setDelayedDraw);
			merger.mergeBasic(getMustDrawByDate(), o.getMustDrawByDate(), this::setMustDrawByDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DelayedDraw _that = getType().cast(o);
		
			if (!Objects.equals(delayedDraw, _that.getDelayedDraw())) return false;
			if (!Objects.equals(mustDrawByDate, _that.getMustDrawByDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (delayedDraw != null ? delayedDraw.hashCode() : 0);
			_result = 31 * _result + (mustDrawByDate != null ? mustDrawByDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DelayedDrawBuilder {" +
				"delayedDraw=" + this.delayedDraw + ", " +
				"mustDrawByDate=" + this.mustDrawByDate +
			'}' + " " + super.toString();
		}
	}
}
