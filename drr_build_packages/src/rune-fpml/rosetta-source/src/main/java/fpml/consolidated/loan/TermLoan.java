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
import fpml.consolidated.loan.meta.TermLoanMeta;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A facility which is fully funded (utilized) at deal closing.
 *
 */
@RosettaDataType(value="TermLoan", builder=TermLoan.TermLoanBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TermLoan", model="fpml", builder=TermLoan.TermLoanBuilderImpl.class, version="2.1.1")
public interface TermLoan extends AbstractFacility {

	TermLoanMeta metaData = new TermLoanMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TermLoan build();
	
	TermLoan.TermLoanBuilder toBuilder();
	
	static TermLoan.TermLoanBuilder builder() {
		return new TermLoan.TermLoanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermLoan> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TermLoan> getType() {
		return TermLoan.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface TermLoanBuilder extends TermLoan, AbstractFacility.AbstractFacilityBuilder {
		@Override
		TermLoan.TermLoanBuilder setId(String id);
		@Override
		TermLoan.TermLoanBuilder setPartyReference(PartyReference partyReference);
		@Override
		TermLoan.TermLoanBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		TermLoan.TermLoanBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		TermLoan.TermLoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		TermLoan.TermLoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		TermLoan.TermLoanBuilder setDescription(String description);
		@Override
		TermLoan.TermLoanBuilder setDealReference(DealReference dealReference);
		@Override
		TermLoan.TermLoanBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		TermLoan.TermLoanBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference);
		@Override
		TermLoan.TermLoanBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference, int idx);
		@Override
		TermLoan.TermLoanBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		TermLoan.TermLoanBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		TermLoan.TermLoanBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		TermLoan.TermLoanBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference);
		@Override
		TermLoan.TermLoanBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference, int idx);
		@Override
		TermLoan.TermLoanBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		TermLoan.TermLoanBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		TermLoan.TermLoanBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		@Override
		TermLoan.TermLoanBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		@Override
		TermLoan.TermLoanBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		TermLoan.TermLoanBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		TermLoan.TermLoanBuilder setStartDate(ZonedDateTime startDate);
		@Override
		TermLoan.TermLoanBuilder setExpiryDate(ZonedDateTime expiryDate);
		@Override
		TermLoan.TermLoanBuilder setMaturityDate(ZonedDateTime maturityDate);
		@Override
		TermLoan.TermLoanBuilder setCurrentCommitment(FacilityCommitment currentCommitment);
		@Override
		TermLoan.TermLoanBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment);
		@Override
		TermLoan.TermLoanBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);
		@Override
		TermLoan.TermLoanBuilder setDealFxRate(FxTerms dealFxRate);
		@Override
		TermLoan.TermLoanBuilder setGoverningLaw(GoverningLaw governingLaw);
		@Override
		TermLoan.TermLoanBuilder addFeature(FacilityFeature feature);
		@Override
		TermLoan.TermLoanBuilder addFeature(FacilityFeature feature, int idx);
		@Override
		TermLoan.TermLoanBuilder addFeature(List<? extends FacilityFeature> feature);
		@Override
		TermLoan.TermLoanBuilder setFeature(List<? extends FacilityFeature> feature);
		@Override
		TermLoan.TermLoanBuilder setLien(Lien lien);
		@Override
		TermLoan.TermLoanBuilder setSeniority(CreditSeniority seniority);
		@Override
		TermLoan.TermLoanBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice);
		@Override
		TermLoan.TermLoanBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice, int idx);
		@Override
		TermLoan.TermLoanBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		TermLoan.TermLoanBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		TermLoan.TermLoanBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);
		@Override
		TermLoan.TermLoanBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption);
		@Override
		TermLoan.TermLoanBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption, int idx);
		@Override
		TermLoan.TermLoanBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		TermLoan.TermLoanBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		TermLoan.TermLoanBuilder setDefaultRate(PeriodRate defaultRate);
		@Override
		TermLoan.TermLoanBuilder setMandatoryCostRate(PeriodRate mandatoryCostRate);
		@Override
		TermLoan.TermLoanBuilder setPenaltyRate(PeriodRate penaltyRate);
		@Override
		TermLoan.TermLoanBuilder setMultiCurrency(MultiCurrency multiCurrency);

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
		}
		

		TermLoan.TermLoanBuilder prune();
	}

	/*********************** Immutable Implementation of TermLoan  ***********************/
	class TermLoanImpl extends AbstractFacility.AbstractFacilityImpl implements TermLoan {
		
		protected TermLoanImpl(TermLoan.TermLoanBuilder builder) {
			super(builder);
		}
		
		@Override
		public TermLoan build() {
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder toBuilder() {
			TermLoan.TermLoanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermLoan.TermLoanBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermLoan {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TermLoan  ***********************/
	class TermLoanBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl implements TermLoan.TermLoanBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TermLoan.TermLoanBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public TermLoan.TermLoanBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public TermLoan.TermLoanBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public TermLoan.TermLoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public TermLoan.TermLoanBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public TermLoan.TermLoanBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public TermLoan.TermLoanBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public TermLoan.TermLoanBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference) {
			if (_coBorrowerPartyReference != null) {
				this.coBorrowerPartyReference.add(_coBorrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference, int idx) {
			getIndex(this.coBorrowerPartyReference, idx, () -> _coBorrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
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
		public TermLoan.TermLoanBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
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
		public TermLoan.TermLoanBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public TermLoan.TermLoanBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference) {
			if (_lcIssuingBankPartyReference != null) {
				this.lcIssuingBankPartyReference.add(_lcIssuingBankPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference, int idx) {
			getIndex(this.lcIssuingBankPartyReference, idx, () -> _lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
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
		public TermLoan.TermLoanBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
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
		public TermLoan.TermLoanBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public TermLoan.TermLoanBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public TermLoan.TermLoanBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public TermLoan.TermLoanBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public TermLoan.TermLoanBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentCommitment")
		@Override
		public TermLoan.TermLoanBuilder setCurrentCommitment(FacilityCommitment _currentCommitment) {
			this.currentCommitment = _currentCommitment == null ? null : _currentCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalCommitment")
		@Override
		public TermLoan.TermLoanBuilder setOriginalCommitment(MoneyWithParticipantShare _originalCommitment) {
			this.originalCommitment = _originalCommitment == null ? null : _originalCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentSchedule")
		@Override
		public TermLoan.TermLoanBuilder setCommitmentSchedule(CommitmentSchedule _commitmentSchedule) {
			this.commitmentSchedule = _commitmentSchedule == null ? null : _commitmentSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealFxRate")
		@Override
		public TermLoan.TermLoanBuilder setDealFxRate(FxTerms _dealFxRate) {
			this.dealFxRate = _dealFxRate == null ? null : _dealFxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("governingLaw")
		@Override
		public TermLoan.TermLoanBuilder setGoverningLaw(GoverningLaw _governingLaw) {
			this.governingLaw = _governingLaw == null ? null : _governingLaw.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public TermLoan.TermLoanBuilder addFeature(FacilityFeature _feature) {
			if (_feature != null) {
				this.feature.add(_feature.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addFeature(FacilityFeature _feature, int idx) {
			getIndex(this.feature, idx, () -> _feature.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addFeature(List<? extends FacilityFeature> features) {
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
		public TermLoan.TermLoanBuilder setFeature(List<? extends FacilityFeature> features) {
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
		public TermLoan.TermLoanBuilder setLien(Lien _lien) {
			this.lien = _lien == null ? null : _lien.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public TermLoan.TermLoanBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public TermLoan.TermLoanBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice) {
			if (_abstractFacilityChoice != null) {
				this.abstractFacilityChoice.add(_abstractFacilityChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice, int idx) {
			getIndex(this.abstractFacilityChoice, idx, () -> _abstractFacilityChoice.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
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
		public TermLoan.TermLoanBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
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
		public TermLoan.TermLoanBuilder setAccruingPikOption(AccruingPikOption _accruingPikOption) {
			this.accruingPikOption = _accruingPikOption == null ? null : _accruingPikOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public TermLoan.TermLoanBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption) {
			if (_accruingFeeOption != null) {
				this.accruingFeeOption.add(_accruingFeeOption.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption, int idx) {
			getIndex(this.accruingFeeOption, idx, () -> _accruingFeeOption.toBuilder());
			return this;
		}
		
		@Override
		public TermLoan.TermLoanBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
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
		public TermLoan.TermLoanBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
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
		public TermLoan.TermLoanBuilder setDefaultRate(PeriodRate _defaultRate) {
			this.defaultRate = _defaultRate == null ? null : _defaultRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryCostRate")
		@Override
		public TermLoan.TermLoanBuilder setMandatoryCostRate(PeriodRate _mandatoryCostRate) {
			this.mandatoryCostRate = _mandatoryCostRate == null ? null : _mandatoryCostRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("penaltyRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("penaltyRate")
		@Override
		public TermLoan.TermLoanBuilder setPenaltyRate(PeriodRate _penaltyRate) {
			this.penaltyRate = _penaltyRate == null ? null : _penaltyRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiCurrency")
		@Override
		public TermLoan.TermLoanBuilder setMultiCurrency(MultiCurrency _multiCurrency) {
			this.multiCurrency = _multiCurrency == null ? null : _multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public TermLoan build() {
			return new TermLoan.TermLoanImpl(this);
		}
		
		@Override
		public TermLoan.TermLoanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermLoan.TermLoanBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermLoan.TermLoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TermLoan.TermLoanBuilder o = (TermLoan.TermLoanBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermLoanBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
