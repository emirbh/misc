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
import fpml.consolidated.loan.meta.TransferFeeDefinitionMeta;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision A structure that represents the rules for payment of transfer fees to the agent.
 *
 */
@RosettaDataType(value="TransferFeeDefinition", builder=TransferFeeDefinition.TransferFeeDefinitionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TransferFeeDefinition", model="fpml", builder=TransferFeeDefinition.TransferFeeDefinitionBuilderImpl.class, version="2.1.1")
public interface TransferFeeDefinition extends RosettaModelObject {

	TransferFeeDefinitionMeta metaData = new TransferFeeDefinitionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount payable to the agent for re-assigning a share in one of the underlying facilities within the deal.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TransferFeeDefinitionChoice> getTransferFeeDefinitionChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The list of lender types which are exempt from paying an transfer fee to the agent bank.
	 *
	 */
	List<? extends LenderClassification> getLenderTypeWaived();

	/*********************** Build Methods  ***********************/
	TransferFeeDefinition build();
	
	TransferFeeDefinition.TransferFeeDefinitionBuilder toBuilder();
	
	static TransferFeeDefinition.TransferFeeDefinitionBuilder builder() {
		return new TransferFeeDefinition.TransferFeeDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransferFeeDefinition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TransferFeeDefinition> getType() {
		return TransferFeeDefinition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("transferFeeDefinitionChoice"), processor, TransferFeeDefinitionChoice.class, getTransferFeeDefinitionChoice());
		processRosetta(path.newSubPath("lenderTypeWaived"), processor, LenderClassification.class, getLenderTypeWaived());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransferFeeDefinitionBuilder extends TransferFeeDefinition, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder getOrCreateTransferFeeDefinitionChoice(int index);
		@Override
		List<? extends TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder> getTransferFeeDefinitionChoice();
		LenderClassification.LenderClassificationBuilder getOrCreateLenderTypeWaived(int index);
		@Override
		List<? extends LenderClassification.LenderClassificationBuilder> getLenderTypeWaived();
		TransferFeeDefinition.TransferFeeDefinitionBuilder setAmount(NonNegativeMoney amount);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addTransferFeeDefinitionChoice(TransferFeeDefinitionChoice transferFeeDefinitionChoice);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addTransferFeeDefinitionChoice(TransferFeeDefinitionChoice transferFeeDefinitionChoice, int idx);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addTransferFeeDefinitionChoice(List<? extends TransferFeeDefinitionChoice> transferFeeDefinitionChoice);
		TransferFeeDefinition.TransferFeeDefinitionBuilder setTransferFeeDefinitionChoice(List<? extends TransferFeeDefinitionChoice> transferFeeDefinitionChoice);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification lenderTypeWaived);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification lenderTypeWaived, int idx);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaived);
		TransferFeeDefinition.TransferFeeDefinitionBuilder setLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaived);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("transferFeeDefinitionChoice"), processor, TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder.class, getTransferFeeDefinitionChoice());
			processRosetta(path.newSubPath("lenderTypeWaived"), processor, LenderClassification.LenderClassificationBuilder.class, getLenderTypeWaived());
		}
		

		TransferFeeDefinition.TransferFeeDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of TransferFeeDefinition  ***********************/
	class TransferFeeDefinitionImpl implements TransferFeeDefinition {
		private final NonNegativeMoney amount;
		private final List<? extends TransferFeeDefinitionChoice> transferFeeDefinitionChoice;
		private final List<? extends LenderClassification> lenderTypeWaived;
		
		protected TransferFeeDefinitionImpl(TransferFeeDefinition.TransferFeeDefinitionBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.transferFeeDefinitionChoice = ofNullable(builder.getTransferFeeDefinitionChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lenderTypeWaived = ofNullable(builder.getLenderTypeWaived()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("transferFeeDefinitionChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transferFeeDefinitionChoice")
		public List<? extends TransferFeeDefinitionChoice> getTransferFeeDefinitionChoice() {
			return transferFeeDefinitionChoice;
		}
		
		@Override
		@RosettaAttribute("lenderTypeWaived")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("lenderTypeWaived")
		public List<? extends LenderClassification> getLenderTypeWaived() {
			return lenderTypeWaived;
		}
		
		@Override
		public TransferFeeDefinition build() {
			return this;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder toBuilder() {
			TransferFeeDefinition.TransferFeeDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferFeeDefinition.TransferFeeDefinitionBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getTransferFeeDefinitionChoice()).ifPresent(builder::setTransferFeeDefinitionChoice);
			ofNullable(getLenderTypeWaived()).ifPresent(builder::setLenderTypeWaived);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeDefinition _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(transferFeeDefinitionChoice, _that.getTransferFeeDefinitionChoice())) return false;
			if (!ListEquals.listEquals(lenderTypeWaived, _that.getLenderTypeWaived())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (transferFeeDefinitionChoice != null ? transferFeeDefinitionChoice.hashCode() : 0);
			_result = 31 * _result + (lenderTypeWaived != null ? lenderTypeWaived.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeDefinition {" +
				"amount=" + this.amount + ", " +
				"transferFeeDefinitionChoice=" + this.transferFeeDefinitionChoice + ", " +
				"lenderTypeWaived=" + this.lenderTypeWaived +
			'}';
		}
	}

	/*********************** Builder Implementation of TransferFeeDefinition  ***********************/
	class TransferFeeDefinitionBuilderImpl implements TransferFeeDefinition.TransferFeeDefinitionBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected List<TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder> transferFeeDefinitionChoice = new ArrayList<>();
		protected List<LenderClassification.LenderClassificationBuilder> lenderTypeWaived = new ArrayList<>();
		
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
		@RosettaAttribute("transferFeeDefinitionChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transferFeeDefinitionChoice")
		public List<? extends TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder> getTransferFeeDefinitionChoice() {
			return transferFeeDefinitionChoice;
		}
		
		@Override
		public TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder getOrCreateTransferFeeDefinitionChoice(int index) {
			if (transferFeeDefinitionChoice==null) {
				this.transferFeeDefinitionChoice = new ArrayList<>();
			}
			return getIndex(transferFeeDefinitionChoice, index, () -> {
						TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder newTransferFeeDefinitionChoice = TransferFeeDefinitionChoice.builder();
						return newTransferFeeDefinitionChoice;
					});
		}
		
		@Override
		@RosettaAttribute("lenderTypeWaived")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("lenderTypeWaived")
		public List<? extends LenderClassification.LenderClassificationBuilder> getLenderTypeWaived() {
			return lenderTypeWaived;
		}
		
		@Override
		public LenderClassification.LenderClassificationBuilder getOrCreateLenderTypeWaived(int index) {
			if (lenderTypeWaived==null) {
				this.lenderTypeWaived = new ArrayList<>();
			}
			return getIndex(lenderTypeWaived, index, () -> {
						LenderClassification.LenderClassificationBuilder newLenderTypeWaived = LenderClassification.builder();
						return newLenderTypeWaived;
					});
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transferFeeDefinitionChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("transferFeeDefinitionChoice")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addTransferFeeDefinitionChoice(TransferFeeDefinitionChoice _transferFeeDefinitionChoice) {
			if (_transferFeeDefinitionChoice != null) {
				this.transferFeeDefinitionChoice.add(_transferFeeDefinitionChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addTransferFeeDefinitionChoice(TransferFeeDefinitionChoice _transferFeeDefinitionChoice, int idx) {
			getIndex(this.transferFeeDefinitionChoice, idx, () -> _transferFeeDefinitionChoice.toBuilder());
			return this;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addTransferFeeDefinitionChoice(List<? extends TransferFeeDefinitionChoice> transferFeeDefinitionChoices) {
			if (transferFeeDefinitionChoices != null) {
				for (final TransferFeeDefinitionChoice toAdd : transferFeeDefinitionChoices) {
					this.transferFeeDefinitionChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("transferFeeDefinitionChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("transferFeeDefinitionChoice")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder setTransferFeeDefinitionChoice(List<? extends TransferFeeDefinitionChoice> transferFeeDefinitionChoices) {
			if (transferFeeDefinitionChoices == null) {
				this.transferFeeDefinitionChoice = new ArrayList<>();
			} else {
				this.transferFeeDefinitionChoice = transferFeeDefinitionChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lenderTypeWaived")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("lenderTypeWaived")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification _lenderTypeWaived) {
			if (_lenderTypeWaived != null) {
				this.lenderTypeWaived.add(_lenderTypeWaived.toBuilder());
			}
			return this;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification _lenderTypeWaived, int idx) {
			getIndex(this.lenderTypeWaived, idx, () -> _lenderTypeWaived.toBuilder());
			return this;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaiveds) {
			if (lenderTypeWaiveds != null) {
				for (final LenderClassification toAdd : lenderTypeWaiveds) {
					this.lenderTypeWaived.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("lenderTypeWaived")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("lenderTypeWaived")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder setLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaiveds) {
			if (lenderTypeWaiveds == null) {
				this.lenderTypeWaived = new ArrayList<>();
			} else {
				this.lenderTypeWaived = lenderTypeWaiveds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TransferFeeDefinition build() {
			return new TransferFeeDefinition.TransferFeeDefinitionImpl(this);
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			transferFeeDefinitionChoice = transferFeeDefinitionChoice.stream().filter(b->b!=null).<TransferFeeDefinitionChoice.TransferFeeDefinitionChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			lenderTypeWaived = lenderTypeWaived.stream().filter(b->b!=null).<LenderClassification.LenderClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getTransferFeeDefinitionChoice()!=null && getTransferFeeDefinitionChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLenderTypeWaived()!=null && getLenderTypeWaived().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferFeeDefinition.TransferFeeDefinitionBuilder o = (TransferFeeDefinition.TransferFeeDefinitionBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getTransferFeeDefinitionChoice(), o.getTransferFeeDefinitionChoice(), this::getOrCreateTransferFeeDefinitionChoice);
			merger.mergeRosetta(getLenderTypeWaived(), o.getLenderTypeWaived(), this::getOrCreateLenderTypeWaived);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeDefinition _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(transferFeeDefinitionChoice, _that.getTransferFeeDefinitionChoice())) return false;
			if (!ListEquals.listEquals(lenderTypeWaived, _that.getLenderTypeWaived())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (transferFeeDefinitionChoice != null ? transferFeeDefinitionChoice.hashCode() : 0);
			_result = 31 * _result + (lenderTypeWaived != null ? lenderTypeWaived.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeDefinitionBuilder {" +
				"amount=" + this.amount + ", " +
				"transferFeeDefinitionChoice=" + this.transferFeeDefinitionChoice + ", " +
				"lenderTypeWaived=" + this.lenderTypeWaived +
			'}';
		}
	}
}
