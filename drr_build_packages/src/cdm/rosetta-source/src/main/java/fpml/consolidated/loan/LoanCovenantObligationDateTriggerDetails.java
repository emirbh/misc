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
import fpml.consolidated.loan.meta.LoanCovenantObligationDateTriggerDetailsMeta;
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
 * Provision A structure to describe the date or frequency by which a covenant obligation must be met.
 *
 */
@RosettaDataType(value="LoanCovenantObligationDateTriggerDetails", builder=LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationDateTriggerDetails", model="fpml", builder=LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationDateTriggerDetails extends RosettaModelObject {

	LoanCovenantObligationDateTriggerDetailsMeta metaData = new LoanCovenantObligationDateTriggerDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanCovenantObligationDateTriggerDetailsChoice> getLoanCovenantObligationDateTriggerDetailsChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional structure to describe a business adjustment to a defined due date, set of due dates, or recurring due date, by which the covenant must be fulfilled without penalty.
	 *
	 */
	DueDateAdjustment getDueDateAdjustment();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationDateTriggerDetails build();
	
	LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder toBuilder();
	
	static LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder builder() {
		return new LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationDateTriggerDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationDateTriggerDetails> getType() {
		return LoanCovenantObligationDateTriggerDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanCovenantObligationDateTriggerDetailsChoice"), processor, LoanCovenantObligationDateTriggerDetailsChoice.class, getLoanCovenantObligationDateTriggerDetailsChoice());
		processRosetta(path.newSubPath("dueDateAdjustment"), processor, DueDateAdjustment.class, getDueDateAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationDateTriggerDetailsBuilder extends LoanCovenantObligationDateTriggerDetails, RosettaModelObjectBuilder {
		LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder getOrCreateLoanCovenantObligationDateTriggerDetailsChoice(int index);
		@Override
		List<? extends LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder> getLoanCovenantObligationDateTriggerDetailsChoice();
		DueDateAdjustment.DueDateAdjustmentBuilder getOrCreateDueDateAdjustment();
		@Override
		DueDateAdjustment.DueDateAdjustmentBuilder getDueDateAdjustment();
		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder addLoanCovenantObligationDateTriggerDetailsChoice(LoanCovenantObligationDateTriggerDetailsChoice loanCovenantObligationDateTriggerDetailsChoice);
		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder addLoanCovenantObligationDateTriggerDetailsChoice(LoanCovenantObligationDateTriggerDetailsChoice loanCovenantObligationDateTriggerDetailsChoice, int idx);
		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder addLoanCovenantObligationDateTriggerDetailsChoice(List<? extends LoanCovenantObligationDateTriggerDetailsChoice> loanCovenantObligationDateTriggerDetailsChoice);
		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder setLoanCovenantObligationDateTriggerDetailsChoice(List<? extends LoanCovenantObligationDateTriggerDetailsChoice> loanCovenantObligationDateTriggerDetailsChoice);
		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder setDueDateAdjustment(DueDateAdjustment dueDateAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanCovenantObligationDateTriggerDetailsChoice"), processor, LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder.class, getLoanCovenantObligationDateTriggerDetailsChoice());
			processRosetta(path.newSubPath("dueDateAdjustment"), processor, DueDateAdjustment.DueDateAdjustmentBuilder.class, getDueDateAdjustment());
		}
		

		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationDateTriggerDetails  ***********************/
	class LoanCovenantObligationDateTriggerDetailsImpl implements LoanCovenantObligationDateTriggerDetails {
		private final List<? extends LoanCovenantObligationDateTriggerDetailsChoice> loanCovenantObligationDateTriggerDetailsChoice;
		private final DueDateAdjustment dueDateAdjustment;
		
		protected LoanCovenantObligationDateTriggerDetailsImpl(LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder builder) {
			this.loanCovenantObligationDateTriggerDetailsChoice = ofNullable(builder.getLoanCovenantObligationDateTriggerDetailsChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dueDateAdjustment = ofNullable(builder.getDueDateAdjustment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		public List<? extends LoanCovenantObligationDateTriggerDetailsChoice> getLoanCovenantObligationDateTriggerDetailsChoice() {
			return loanCovenantObligationDateTriggerDetailsChoice;
		}
		
		@Override
		@RosettaAttribute("dueDateAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dueDateAdjustment")
		public DueDateAdjustment getDueDateAdjustment() {
			return dueDateAdjustment;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetails build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder toBuilder() {
			LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder builder) {
			ofNullable(getLoanCovenantObligationDateTriggerDetailsChoice()).ifPresent(builder::setLoanCovenantObligationDateTriggerDetailsChoice);
			ofNullable(getDueDateAdjustment()).ifPresent(builder::setDueDateAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationDateTriggerDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanCovenantObligationDateTriggerDetailsChoice, _that.getLoanCovenantObligationDateTriggerDetailsChoice())) return false;
			if (!Objects.equals(dueDateAdjustment, _that.getDueDateAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanCovenantObligationDateTriggerDetailsChoice != null ? loanCovenantObligationDateTriggerDetailsChoice.hashCode() : 0);
			_result = 31 * _result + (dueDateAdjustment != null ? dueDateAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationDateTriggerDetails {" +
				"loanCovenantObligationDateTriggerDetailsChoice=" + this.loanCovenantObligationDateTriggerDetailsChoice + ", " +
				"dueDateAdjustment=" + this.dueDateAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationDateTriggerDetails  ***********************/
	class LoanCovenantObligationDateTriggerDetailsBuilderImpl implements LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder {
	
		protected List<LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder> loanCovenantObligationDateTriggerDetailsChoice = new ArrayList<>();
		protected DueDateAdjustment.DueDateAdjustmentBuilder dueDateAdjustment;
		
		@Override
		@RosettaAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		public List<? extends LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder> getLoanCovenantObligationDateTriggerDetailsChoice() {
			return loanCovenantObligationDateTriggerDetailsChoice;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder getOrCreateLoanCovenantObligationDateTriggerDetailsChoice(int index) {
			if (loanCovenantObligationDateTriggerDetailsChoice==null) {
				this.loanCovenantObligationDateTriggerDetailsChoice = new ArrayList<>();
			}
			return getIndex(loanCovenantObligationDateTriggerDetailsChoice, index, () -> {
						LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder newLoanCovenantObligationDateTriggerDetailsChoice = LoanCovenantObligationDateTriggerDetailsChoice.builder();
						return newLoanCovenantObligationDateTriggerDetailsChoice;
					});
		}
		
		@Override
		@RosettaAttribute("dueDateAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dueDateAdjustment")
		public DueDateAdjustment.DueDateAdjustmentBuilder getDueDateAdjustment() {
			return dueDateAdjustment;
		}
		
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder getOrCreateDueDateAdjustment() {
			DueDateAdjustment.DueDateAdjustmentBuilder result;
			if (dueDateAdjustment!=null) {
				result = dueDateAdjustment;
			}
			else {
				result = dueDateAdjustment = DueDateAdjustment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder addLoanCovenantObligationDateTriggerDetailsChoice(LoanCovenantObligationDateTriggerDetailsChoice _loanCovenantObligationDateTriggerDetailsChoice) {
			if (_loanCovenantObligationDateTriggerDetailsChoice != null) {
				this.loanCovenantObligationDateTriggerDetailsChoice.add(_loanCovenantObligationDateTriggerDetailsChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder addLoanCovenantObligationDateTriggerDetailsChoice(LoanCovenantObligationDateTriggerDetailsChoice _loanCovenantObligationDateTriggerDetailsChoice, int idx) {
			getIndex(this.loanCovenantObligationDateTriggerDetailsChoice, idx, () -> _loanCovenantObligationDateTriggerDetailsChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder addLoanCovenantObligationDateTriggerDetailsChoice(List<? extends LoanCovenantObligationDateTriggerDetailsChoice> loanCovenantObligationDateTriggerDetailsChoices) {
			if (loanCovenantObligationDateTriggerDetailsChoices != null) {
				for (final LoanCovenantObligationDateTriggerDetailsChoice toAdd : loanCovenantObligationDateTriggerDetailsChoices) {
					this.loanCovenantObligationDateTriggerDetailsChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationDateTriggerDetailsChoice")
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder setLoanCovenantObligationDateTriggerDetailsChoice(List<? extends LoanCovenantObligationDateTriggerDetailsChoice> loanCovenantObligationDateTriggerDetailsChoices) {
			if (loanCovenantObligationDateTriggerDetailsChoices == null) {
				this.loanCovenantObligationDateTriggerDetailsChoice = new ArrayList<>();
			} else {
				this.loanCovenantObligationDateTriggerDetailsChoice = loanCovenantObligationDateTriggerDetailsChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dueDateAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dueDateAdjustment")
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder setDueDateAdjustment(DueDateAdjustment _dueDateAdjustment) {
			this.dueDateAdjustment = _dueDateAdjustment == null ? null : _dueDateAdjustment.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetails build() {
			return new LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsImpl(this);
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder prune() {
			loanCovenantObligationDateTriggerDetailsChoice = loanCovenantObligationDateTriggerDetailsChoice.stream().filter(b->b!=null).<LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (dueDateAdjustment!=null && !dueDateAdjustment.prune().hasData()) dueDateAdjustment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanCovenantObligationDateTriggerDetailsChoice()!=null && getLoanCovenantObligationDateTriggerDetailsChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDueDateAdjustment()!=null && getDueDateAdjustment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder o = (LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder) other;
			
			merger.mergeRosetta(getLoanCovenantObligationDateTriggerDetailsChoice(), o.getLoanCovenantObligationDateTriggerDetailsChoice(), this::getOrCreateLoanCovenantObligationDateTriggerDetailsChoice);
			merger.mergeRosetta(getDueDateAdjustment(), o.getDueDateAdjustment(), this::setDueDateAdjustment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationDateTriggerDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanCovenantObligationDateTriggerDetailsChoice, _that.getLoanCovenantObligationDateTriggerDetailsChoice())) return false;
			if (!Objects.equals(dueDateAdjustment, _that.getDueDateAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanCovenantObligationDateTriggerDetailsChoice != null ? loanCovenantObligationDateTriggerDetailsChoice.hashCode() : 0);
			_result = 31 * _result + (dueDateAdjustment != null ? dueDateAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationDateTriggerDetailsBuilder {" +
				"loanCovenantObligationDateTriggerDetailsChoice=" + this.loanCovenantObligationDateTriggerDetailsChoice + ", " +
				"dueDateAdjustment=" + this.dueDateAdjustment +
			'}';
		}
	}
}
