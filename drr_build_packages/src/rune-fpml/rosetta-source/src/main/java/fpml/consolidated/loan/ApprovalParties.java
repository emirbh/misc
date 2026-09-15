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
import fpml.consolidated.loan.meta.ApprovalPartiesMeta;
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
 * Provision A structure to describe the eligible and ineligible parties to vote on an action (e.g. a legal action).
 *
 */
@RosettaDataType(value="ApprovalParties", builder=ApprovalParties.ApprovalPartiesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApprovalParties", model="fpml", builder=ApprovalParties.ApprovalPartiesBuilderImpl.class, version="2.1.1")
public interface ApprovalParties extends RosettaModelObject {

	ApprovalPartiesMeta metaData = new ApprovalPartiesMeta();

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
	List<? extends ApprovalPartiesChoice> getApprovalPartiesChoice();

	/*********************** Build Methods  ***********************/
	ApprovalParties build();
	
	ApprovalParties.ApprovalPartiesBuilder toBuilder();
	
	static ApprovalParties.ApprovalPartiesBuilder builder() {
		return new ApprovalParties.ApprovalPartiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalParties> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApprovalParties> getType() {
		return ApprovalParties.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("approvalPartiesChoice"), processor, ApprovalPartiesChoice.class, getApprovalPartiesChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalPartiesBuilder extends ApprovalParties, RosettaModelObjectBuilder {
		ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder getOrCreateApprovalPartiesChoice(int index);
		@Override
		List<? extends ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder> getApprovalPartiesChoice();
		ApprovalParties.ApprovalPartiesBuilder addApprovalPartiesChoice(ApprovalPartiesChoice approvalPartiesChoice);
		ApprovalParties.ApprovalPartiesBuilder addApprovalPartiesChoice(ApprovalPartiesChoice approvalPartiesChoice, int idx);
		ApprovalParties.ApprovalPartiesBuilder addApprovalPartiesChoice(List<? extends ApprovalPartiesChoice> approvalPartiesChoice);
		ApprovalParties.ApprovalPartiesBuilder setApprovalPartiesChoice(List<? extends ApprovalPartiesChoice> approvalPartiesChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("approvalPartiesChoice"), processor, ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder.class, getApprovalPartiesChoice());
		}
		

		ApprovalParties.ApprovalPartiesBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalParties  ***********************/
	class ApprovalPartiesImpl implements ApprovalParties {
		private final List<? extends ApprovalPartiesChoice> approvalPartiesChoice;
		
		protected ApprovalPartiesImpl(ApprovalParties.ApprovalPartiesBuilder builder) {
			this.approvalPartiesChoice = ofNullable(builder.getApprovalPartiesChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("approvalPartiesChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("approvalPartiesChoice")
		public List<? extends ApprovalPartiesChoice> getApprovalPartiesChoice() {
			return approvalPartiesChoice;
		}
		
		@Override
		public ApprovalParties build() {
			return this;
		}
		
		@Override
		public ApprovalParties.ApprovalPartiesBuilder toBuilder() {
			ApprovalParties.ApprovalPartiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalParties.ApprovalPartiesBuilder builder) {
			ofNullable(getApprovalPartiesChoice()).ifPresent(builder::setApprovalPartiesChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalParties _that = getType().cast(o);
		
			if (!ListEquals.listEquals(approvalPartiesChoice, _that.getApprovalPartiesChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approvalPartiesChoice != null ? approvalPartiesChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalParties {" +
				"approvalPartiesChoice=" + this.approvalPartiesChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of ApprovalParties  ***********************/
	class ApprovalPartiesBuilderImpl implements ApprovalParties.ApprovalPartiesBuilder {
	
		protected List<ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder> approvalPartiesChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("approvalPartiesChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("approvalPartiesChoice")
		public List<? extends ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder> getApprovalPartiesChoice() {
			return approvalPartiesChoice;
		}
		
		@Override
		public ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder getOrCreateApprovalPartiesChoice(int index) {
			if (approvalPartiesChoice==null) {
				this.approvalPartiesChoice = new ArrayList<>();
			}
			return getIndex(approvalPartiesChoice, index, () -> {
						ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder newApprovalPartiesChoice = ApprovalPartiesChoice.builder();
						return newApprovalPartiesChoice;
					});
		}
		
		@RosettaAttribute("approvalPartiesChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("approvalPartiesChoice")
		@Override
		public ApprovalParties.ApprovalPartiesBuilder addApprovalPartiesChoice(ApprovalPartiesChoice _approvalPartiesChoice) {
			if (_approvalPartiesChoice != null) {
				this.approvalPartiesChoice.add(_approvalPartiesChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApprovalParties.ApprovalPartiesBuilder addApprovalPartiesChoice(ApprovalPartiesChoice _approvalPartiesChoice, int idx) {
			getIndex(this.approvalPartiesChoice, idx, () -> _approvalPartiesChoice.toBuilder());
			return this;
		}
		
		@Override
		public ApprovalParties.ApprovalPartiesBuilder addApprovalPartiesChoice(List<? extends ApprovalPartiesChoice> approvalPartiesChoices) {
			if (approvalPartiesChoices != null) {
				for (final ApprovalPartiesChoice toAdd : approvalPartiesChoices) {
					this.approvalPartiesChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("approvalPartiesChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("approvalPartiesChoice")
		@Override
		public ApprovalParties.ApprovalPartiesBuilder setApprovalPartiesChoice(List<? extends ApprovalPartiesChoice> approvalPartiesChoices) {
			if (approvalPartiesChoices == null) {
				this.approvalPartiesChoice = new ArrayList<>();
			} else {
				this.approvalPartiesChoice = approvalPartiesChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ApprovalParties build() {
			return new ApprovalParties.ApprovalPartiesImpl(this);
		}
		
		@Override
		public ApprovalParties.ApprovalPartiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalParties.ApprovalPartiesBuilder prune() {
			approvalPartiesChoice = approvalPartiesChoice.stream().filter(b->b!=null).<ApprovalPartiesChoice.ApprovalPartiesChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApprovalPartiesChoice()!=null && getApprovalPartiesChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalParties.ApprovalPartiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApprovalParties.ApprovalPartiesBuilder o = (ApprovalParties.ApprovalPartiesBuilder) other;
			
			merger.mergeRosetta(getApprovalPartiesChoice(), o.getApprovalPartiesChoice(), this::getOrCreateApprovalPartiesChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalParties _that = getType().cast(o);
		
			if (!ListEquals.listEquals(approvalPartiesChoice, _that.getApprovalPartiesChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approvalPartiesChoice != null ? approvalPartiesChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalPartiesBuilder {" +
				"approvalPartiesChoice=" + this.approvalPartiesChoice +
			'}';
		}
	}
}
