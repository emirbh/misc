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
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.loan.meta.LoanTradeSummaryMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
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
 * Provision A structure that defines all loan trade information i.e. this structure contains the main (e.g. fund manager/main counterparty) trade details.
 *
 */
@RosettaDataType(value="LoanTradeSummary", builder=LoanTradeSummary.LoanTradeSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeSummary", model="fpml", builder=LoanTradeSummary.LoanTradeSummaryBuilderImpl.class, version="2.1.1")
public interface LoanTradeSummary extends TradeIdentifier {

	LoanTradeSummaryMeta metaData = new LoanTradeSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the facility traded.
	 *
	 */
	FacilityReference getFacilityReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The commitment amount traded as of the original trade date.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A freetext field which allows the sender to add further details around the trade event.
	 *
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	LoanTradeSummary build();
	
	LoanTradeSummary.LoanTradeSummaryBuilder toBuilder();
	
	static LoanTradeSummary.LoanTradeSummaryBuilder builder() {
		return new LoanTradeSummary.LoanTradeSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeSummary> getType() {
		return LoanTradeSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.class, getTradeIdentifierChoice());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeSummaryBuilder extends LoanTradeSummary, TradeIdentifier.TradeIdentifierBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		@Override
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder setId(String id);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder setIssuer(IssuerId issuer);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder setTradeId(TradeId tradeId);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder setAccountReference(AccountReference accountReference);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		LoanTradeSummary.LoanTradeSummaryBuilder setFacilityReference(FacilityReference facilityReference);
		LoanTradeSummary.LoanTradeSummaryBuilder setAmount(NonNegativeMoney amount);
		LoanTradeSummary.LoanTradeSummaryBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		LoanTradeSummary.LoanTradeSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeSummary  ***********************/
	class LoanTradeSummaryImpl extends TradeIdentifier.TradeIdentifierImpl implements LoanTradeSummary {
		private final FacilityReference facilityReference;
		private final NonNegativeMoney amount;
		private final String comment;
		
		protected LoanTradeSummaryImpl(LoanTradeSummary.LoanTradeSummaryBuilder builder) {
			super(builder);
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.comment = builder.getComment();
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("comment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		public LoanTradeSummary build() {
			return this;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder toBuilder() {
			LoanTradeSummary.LoanTradeSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeSummary.LoanTradeSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSummary _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSummary {" +
				"facilityReference=" + this.facilityReference + ", " +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeSummary  ***********************/
	class LoanTradeSummaryBuilderImpl extends TradeIdentifier.TradeIdentifierBuilderImpl implements LoanTradeSummary.LoanTradeSummaryBuilder {
	
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected String comment;
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("comment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices != null) {
				for (final TradeIdentifierChoice toAdd : tradeIdentifierChoices) {
					this.tradeIdentifierChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices == null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			} else {
				this.tradeIdentifierChoice = tradeIdentifierChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@Override
		public LoanTradeSummary build() {
			return new LoanTradeSummary.LoanTradeSummaryImpl(this);
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder prune() {
			super.prune();
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeSummary.LoanTradeSummaryBuilder o = (LoanTradeSummary.LoanTradeSummaryBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSummary _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSummaryBuilder {" +
				"facilityReference=" + this.facilityReference + ", " +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}' + " " + super.toString();
		}
	}
}
