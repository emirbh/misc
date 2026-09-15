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
import fpml.consolidated.loan.meta.VoteQuantityMeta;
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
 * Provision A structure to describe a vote quantity as a percent and optionally as a commitment amount.
 *
 */
@RosettaDataType(value="VoteQuantity", builder=VoteQuantity.VoteQuantityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VoteQuantity", model="fpml", builder=VoteQuantity.VoteQuantityBuilderImpl.class, version="2.1.1")
public interface VoteQuantity extends RosettaModelObject {

	VoteQuantityMeta metaData = new VoteQuantityMeta();

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
	List<? extends VoteQuantityChoice> getVoteQuantityChoice();

	/*********************** Build Methods  ***********************/
	VoteQuantity build();
	
	VoteQuantity.VoteQuantityBuilder toBuilder();
	
	static VoteQuantity.VoteQuantityBuilder builder() {
		return new VoteQuantity.VoteQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VoteQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VoteQuantity> getType() {
		return VoteQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("voteQuantityChoice"), processor, VoteQuantityChoice.class, getVoteQuantityChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VoteQuantityBuilder extends VoteQuantity, RosettaModelObjectBuilder {
		VoteQuantityChoice.VoteQuantityChoiceBuilder getOrCreateVoteQuantityChoice(int index);
		@Override
		List<? extends VoteQuantityChoice.VoteQuantityChoiceBuilder> getVoteQuantityChoice();
		VoteQuantity.VoteQuantityBuilder addVoteQuantityChoice(VoteQuantityChoice voteQuantityChoice);
		VoteQuantity.VoteQuantityBuilder addVoteQuantityChoice(VoteQuantityChoice voteQuantityChoice, int idx);
		VoteQuantity.VoteQuantityBuilder addVoteQuantityChoice(List<? extends VoteQuantityChoice> voteQuantityChoice);
		VoteQuantity.VoteQuantityBuilder setVoteQuantityChoice(List<? extends VoteQuantityChoice> voteQuantityChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("voteQuantityChoice"), processor, VoteQuantityChoice.VoteQuantityChoiceBuilder.class, getVoteQuantityChoice());
		}
		

		VoteQuantity.VoteQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of VoteQuantity  ***********************/
	class VoteQuantityImpl implements VoteQuantity {
		private final List<? extends VoteQuantityChoice> voteQuantityChoice;
		
		protected VoteQuantityImpl(VoteQuantity.VoteQuantityBuilder builder) {
			this.voteQuantityChoice = ofNullable(builder.getVoteQuantityChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("voteQuantityChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("voteQuantityChoice")
		public List<? extends VoteQuantityChoice> getVoteQuantityChoice() {
			return voteQuantityChoice;
		}
		
		@Override
		public VoteQuantity build() {
			return this;
		}
		
		@Override
		public VoteQuantity.VoteQuantityBuilder toBuilder() {
			VoteQuantity.VoteQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VoteQuantity.VoteQuantityBuilder builder) {
			ofNullable(getVoteQuantityChoice()).ifPresent(builder::setVoteQuantityChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VoteQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(voteQuantityChoice, _that.getVoteQuantityChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (voteQuantityChoice != null ? voteQuantityChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VoteQuantity {" +
				"voteQuantityChoice=" + this.voteQuantityChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of VoteQuantity  ***********************/
	class VoteQuantityBuilderImpl implements VoteQuantity.VoteQuantityBuilder {
	
		protected List<VoteQuantityChoice.VoteQuantityChoiceBuilder> voteQuantityChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("voteQuantityChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("voteQuantityChoice")
		public List<? extends VoteQuantityChoice.VoteQuantityChoiceBuilder> getVoteQuantityChoice() {
			return voteQuantityChoice;
		}
		
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder getOrCreateVoteQuantityChoice(int index) {
			if (voteQuantityChoice==null) {
				this.voteQuantityChoice = new ArrayList<>();
			}
			return getIndex(voteQuantityChoice, index, () -> {
						VoteQuantityChoice.VoteQuantityChoiceBuilder newVoteQuantityChoice = VoteQuantityChoice.builder();
						return newVoteQuantityChoice;
					});
		}
		
		@RosettaAttribute("voteQuantityChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("voteQuantityChoice")
		@Override
		public VoteQuantity.VoteQuantityBuilder addVoteQuantityChoice(VoteQuantityChoice _voteQuantityChoice) {
			if (_voteQuantityChoice != null) {
				this.voteQuantityChoice.add(_voteQuantityChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public VoteQuantity.VoteQuantityBuilder addVoteQuantityChoice(VoteQuantityChoice _voteQuantityChoice, int idx) {
			getIndex(this.voteQuantityChoice, idx, () -> _voteQuantityChoice.toBuilder());
			return this;
		}
		
		@Override
		public VoteQuantity.VoteQuantityBuilder addVoteQuantityChoice(List<? extends VoteQuantityChoice> voteQuantityChoices) {
			if (voteQuantityChoices != null) {
				for (final VoteQuantityChoice toAdd : voteQuantityChoices) {
					this.voteQuantityChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("voteQuantityChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("voteQuantityChoice")
		@Override
		public VoteQuantity.VoteQuantityBuilder setVoteQuantityChoice(List<? extends VoteQuantityChoice> voteQuantityChoices) {
			if (voteQuantityChoices == null) {
				this.voteQuantityChoice = new ArrayList<>();
			} else {
				this.voteQuantityChoice = voteQuantityChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public VoteQuantity build() {
			return new VoteQuantity.VoteQuantityImpl(this);
		}
		
		@Override
		public VoteQuantity.VoteQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VoteQuantity.VoteQuantityBuilder prune() {
			voteQuantityChoice = voteQuantityChoice.stream().filter(b->b!=null).<VoteQuantityChoice.VoteQuantityChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVoteQuantityChoice()!=null && getVoteQuantityChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VoteQuantity.VoteQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VoteQuantity.VoteQuantityBuilder o = (VoteQuantity.VoteQuantityBuilder) other;
			
			merger.mergeRosetta(getVoteQuantityChoice(), o.getVoteQuantityChoice(), this::getOrCreateVoteQuantityChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VoteQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(voteQuantityChoice, _that.getVoteQuantityChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (voteQuantityChoice != null ? voteQuantityChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VoteQuantityBuilder {" +
				"voteQuantityChoice=" + this.voteQuantityChoice +
			'}';
		}
	}
}
