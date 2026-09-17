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
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.loan.meta.LoanAllocationSummaryMeta;
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
 * Provision A structure defining fundamental allocation event information.
 *
 */
@RosettaDataType(value="LoanAllocationSummary", builder=LoanAllocationSummary.LoanAllocationSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationSummary", model="fpml", builder=LoanAllocationSummary.LoanAllocationSummaryBuilderImpl.class, version="2.1.1")
public interface LoanAllocationSummary extends LoanAllocationIdentifier {

	LoanAllocationSummaryMeta metaData = new LoanAllocationSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Amount allocated.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A freetext field which allows the sender to add further details around the allocation event.
	 *
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	LoanAllocationSummary build();
	
	LoanAllocationSummary.LoanAllocationSummaryBuilder toBuilder();
	
	static LoanAllocationSummary.LoanAllocationSummaryBuilder builder() {
		return new LoanAllocationSummary.LoanAllocationSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationSummary> getType() {
		return LoanAllocationSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.class, getTradeIdentifierChoice());
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSummaryBuilder extends LoanAllocationSummary, LoanAllocationIdentifier.LoanAllocationIdentifierBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder setId(String id);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder setIssuer(IssuerId issuer);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder setTradeId(TradeId tradeId);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder setAccountReference(AccountReference accountReference);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		LoanAllocationSummary.LoanAllocationSummaryBuilder setAmount(NonNegativeMoney amount);
		LoanAllocationSummary.LoanAllocationSummaryBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		LoanAllocationSummary.LoanAllocationSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSummary  ***********************/
	class LoanAllocationSummaryImpl extends LoanAllocationIdentifier.LoanAllocationIdentifierImpl implements LoanAllocationSummary {
		private final NonNegativeMoney amount;
		private final String comment;
		
		protected LoanAllocationSummaryImpl(LoanAllocationSummary.LoanAllocationSummaryBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.comment = builder.getComment();
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
		public LoanAllocationSummary build() {
			return this;
		}
		
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder toBuilder() {
			LoanAllocationSummary.LoanAllocationSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSummary.LoanAllocationSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSummary _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSummary {" +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSummary  ***********************/
	class LoanAllocationSummaryBuilderImpl extends LoanAllocationIdentifier.LoanAllocationIdentifierBuilderImpl implements LoanAllocationSummary.LoanAllocationSummaryBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected String comment;
		
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
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
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
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices == null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			} else {
				this.tradeIdentifierChoice = tradeIdentifierChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@Override
		public LoanAllocationSummary build() {
			return new LoanAllocationSummary.LoanAllocationSummaryImpl(this);
		}
		
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationSummary.LoanAllocationSummaryBuilder o = (LoanAllocationSummary.LoanAllocationSummaryBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSummary _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSummaryBuilder {" +
				"amount=" + this.amount + ", " +
				"comment=" + this.comment +
			'}' + " " + super.toString();
		}
	}
}
