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
import fpml.consolidated.loan.meta.LoanAllocationIdentifierMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
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
 * Provision A structure that contains sender-specific and optional shared loan allocation identifiers.
 *
 */
@RosettaDataType(value="LoanAllocationIdentifier", builder=LoanAllocationIdentifier.LoanAllocationIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationIdentifier", model="fpml", builder=LoanAllocationIdentifier.LoanAllocationIdentifierBuilderImpl.class, version="2.1.1")
public interface LoanAllocationIdentifier extends TradeIdentifier {

	LoanAllocationIdentifierMeta metaData = new LoanAllocationIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the original loan trade.
	 *
	 */
	LoanTradeReference getLoanTradeReference();

	/*********************** Build Methods  ***********************/
	LoanAllocationIdentifier build();
	
	LoanAllocationIdentifier.LoanAllocationIdentifierBuilder toBuilder();
	
	static LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder() {
		return new LoanAllocationIdentifier.LoanAllocationIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationIdentifier> getType() {
		return LoanAllocationIdentifier.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationIdentifierBuilder extends LoanAllocationIdentifier, TradeIdentifier.TradeIdentifierBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference();
		@Override
		LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference();
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setId(String id);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setIssuer(IssuerId issuer);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setTradeId(TradeId tradeId);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setAccountReference(AccountReference accountReference);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
		}
		

		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationIdentifier  ***********************/
	class LoanAllocationIdentifierImpl extends TradeIdentifier.TradeIdentifierImpl implements LoanAllocationIdentifier {
		private final LoanTradeReference loanTradeReference;
		
		protected LoanAllocationIdentifierImpl(LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder) {
			super(builder);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		public LoanTradeReference getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanAllocationIdentifier build() {
			return this;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder toBuilder() {
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationIdentifier {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationIdentifier  ***********************/
	class LoanAllocationIdentifierBuilderImpl extends TradeIdentifier.TradeIdentifierBuilderImpl implements LoanAllocationIdentifier.LoanAllocationIdentifierBuilder {
	
		protected LoanTradeReference.LoanTradeReferenceBuilder loanTradeReference;
		
		@Override
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (loanTradeReference!=null) {
				result = loanTradeReference;
			}
			else {
				result = loanTradeReference = LoanTradeReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
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
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
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
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationIdentifier build() {
			return new LoanAllocationIdentifier.LoanAllocationIdentifierImpl(this);
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder prune() {
			super.prune();
			if (loanTradeReference!=null && !loanTradeReference.prune().hasData()) loanTradeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder o = (LoanAllocationIdentifier.LoanAllocationIdentifierBuilder) other;
			
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::setLoanTradeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationIdentifierBuilder {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}
}
