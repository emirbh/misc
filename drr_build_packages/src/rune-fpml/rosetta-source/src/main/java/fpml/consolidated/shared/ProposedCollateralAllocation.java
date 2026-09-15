package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.ProposedCollateralAllocationMeta;
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
 * Provision The proposed collateral allocation.
 *
 */
@RosettaDataType(value="ProposedCollateralAllocation", builder=ProposedCollateralAllocation.ProposedCollateralAllocationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ProposedCollateralAllocation", model="fpml", builder=ProposedCollateralAllocation.ProposedCollateralAllocationBuilderImpl.class, version="2.1.1")
public interface ProposedCollateralAllocation extends RosettaModelObject {

	ProposedCollateralAllocationMeta metaData = new ProposedCollateralAllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getAllocationPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAllocationAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends ProposedCollateralAllocationChoice> getProposedCollateralAllocationChoice();

	/*********************** Build Methods  ***********************/
	ProposedCollateralAllocation build();
	
	ProposedCollateralAllocation.ProposedCollateralAllocationBuilder toBuilder();
	
	static ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder() {
		return new ProposedCollateralAllocation.ProposedCollateralAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProposedCollateralAllocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProposedCollateralAllocation> getType() {
		return ProposedCollateralAllocation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationPartyReference"), processor, PartyReference.class, getAllocationPartyReference());
		processRosetta(path.newSubPath("allocationAccountReference"), processor, AccountReference.class, getAllocationAccountReference());
		processRosetta(path.newSubPath("proposedCollateralAllocationChoice"), processor, ProposedCollateralAllocationChoice.class, getProposedCollateralAllocationChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProposedCollateralAllocationBuilder extends ProposedCollateralAllocation, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAllocationPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getAllocationPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAllocationAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAllocationAccountReference();
		ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder getOrCreateProposedCollateralAllocationChoice(int index);
		@Override
		List<? extends ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder> getProposedCollateralAllocationChoice();
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setAllocationPartyReference(PartyReference allocationPartyReference);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setAllocationAccountReference(AccountReference allocationAccountReference);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice proposedCollateralAllocationChoice);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice proposedCollateralAllocationChoice, int idx);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoice);
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAllocationPartyReference());
			processRosetta(path.newSubPath("allocationAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAllocationAccountReference());
			processRosetta(path.newSubPath("proposedCollateralAllocationChoice"), processor, ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder.class, getProposedCollateralAllocationChoice());
		}
		

		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of ProposedCollateralAllocation  ***********************/
	class ProposedCollateralAllocationImpl implements ProposedCollateralAllocation {
		private final PartyReference allocationPartyReference;
		private final AccountReference allocationAccountReference;
		private final List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoice;
		
		protected ProposedCollateralAllocationImpl(ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder) {
			this.allocationPartyReference = ofNullable(builder.getAllocationPartyReference()).map(f->f.build()).orElse(null);
			this.allocationAccountReference = ofNullable(builder.getAllocationAccountReference()).map(f->f.build()).orElse(null);
			this.proposedCollateralAllocationChoice = ofNullable(builder.getProposedCollateralAllocationChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationPartyReference")
		public PartyReference getAllocationPartyReference() {
			return allocationPartyReference;
		}
		
		@Override
		@RosettaAttribute("allocationAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationAccountReference")
		public AccountReference getAllocationAccountReference() {
			return allocationAccountReference;
		}
		
		@Override
		@RosettaAttribute("proposedCollateralAllocationChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("proposedCollateralAllocationChoice")
		public List<? extends ProposedCollateralAllocationChoice> getProposedCollateralAllocationChoice() {
			return proposedCollateralAllocationChoice;
		}
		
		@Override
		public ProposedCollateralAllocation build() {
			return this;
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder toBuilder() {
			ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProposedCollateralAllocation.ProposedCollateralAllocationBuilder builder) {
			ofNullable(getAllocationPartyReference()).ifPresent(builder::setAllocationPartyReference);
			ofNullable(getAllocationAccountReference()).ifPresent(builder::setAllocationAccountReference);
			ofNullable(getProposedCollateralAllocationChoice()).ifPresent(builder::setProposedCollateralAllocationChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(allocationPartyReference, _that.getAllocationPartyReference())) return false;
			if (!Objects.equals(allocationAccountReference, _that.getAllocationAccountReference())) return false;
			if (!ListEquals.listEquals(proposedCollateralAllocationChoice, _that.getProposedCollateralAllocationChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationPartyReference != null ? allocationPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocationAccountReference != null ? allocationAccountReference.hashCode() : 0);
			_result = 31 * _result + (proposedCollateralAllocationChoice != null ? proposedCollateralAllocationChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedCollateralAllocation {" +
				"allocationPartyReference=" + this.allocationPartyReference + ", " +
				"allocationAccountReference=" + this.allocationAccountReference + ", " +
				"proposedCollateralAllocationChoice=" + this.proposedCollateralAllocationChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of ProposedCollateralAllocation  ***********************/
	class ProposedCollateralAllocationBuilderImpl implements ProposedCollateralAllocation.ProposedCollateralAllocationBuilder {
	
		protected PartyReference.PartyReferenceBuilder allocationPartyReference;
		protected AccountReference.AccountReferenceBuilder allocationAccountReference;
		protected List<ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder> proposedCollateralAllocationChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("allocationPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationPartyReference")
		public PartyReference.PartyReferenceBuilder getAllocationPartyReference() {
			return allocationPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAllocationPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (allocationPartyReference!=null) {
				result = allocationPartyReference;
			}
			else {
				result = allocationPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationAccountReference")
		public AccountReference.AccountReferenceBuilder getAllocationAccountReference() {
			return allocationAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAllocationAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (allocationAccountReference!=null) {
				result = allocationAccountReference;
			}
			else {
				result = allocationAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("proposedCollateralAllocationChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("proposedCollateralAllocationChoice")
		public List<? extends ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder> getProposedCollateralAllocationChoice() {
			return proposedCollateralAllocationChoice;
		}
		
		@Override
		public ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder getOrCreateProposedCollateralAllocationChoice(int index) {
			if (proposedCollateralAllocationChoice==null) {
				this.proposedCollateralAllocationChoice = new ArrayList<>();
			}
			return getIndex(proposedCollateralAllocationChoice, index, () -> {
						ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder newProposedCollateralAllocationChoice = ProposedCollateralAllocationChoice.builder();
						return newProposedCollateralAllocationChoice;
					});
		}
		
		@RosettaAttribute("allocationPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationPartyReference")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setAllocationPartyReference(PartyReference _allocationPartyReference) {
			this.allocationPartyReference = _allocationPartyReference == null ? null : _allocationPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocationAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationAccountReference")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setAllocationAccountReference(AccountReference _allocationAccountReference) {
			this.allocationAccountReference = _allocationAccountReference == null ? null : _allocationAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("proposedCollateralAllocationChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("proposedCollateralAllocationChoice")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice _proposedCollateralAllocationChoice) {
			if (_proposedCollateralAllocationChoice != null) {
				this.proposedCollateralAllocationChoice.add(_proposedCollateralAllocationChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(ProposedCollateralAllocationChoice _proposedCollateralAllocationChoice, int idx) {
			getIndex(this.proposedCollateralAllocationChoice, idx, () -> _proposedCollateralAllocationChoice.toBuilder());
			return this;
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder addProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoices) {
			if (proposedCollateralAllocationChoices != null) {
				for (final ProposedCollateralAllocationChoice toAdd : proposedCollateralAllocationChoices) {
					this.proposedCollateralAllocationChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("proposedCollateralAllocationChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("proposedCollateralAllocationChoice")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder setProposedCollateralAllocationChoice(List<? extends ProposedCollateralAllocationChoice> proposedCollateralAllocationChoices) {
			if (proposedCollateralAllocationChoices == null) {
				this.proposedCollateralAllocationChoice = new ArrayList<>();
			} else {
				this.proposedCollateralAllocationChoice = proposedCollateralAllocationChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProposedCollateralAllocation build() {
			return new ProposedCollateralAllocation.ProposedCollateralAllocationImpl(this);
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder prune() {
			if (allocationPartyReference!=null && !allocationPartyReference.prune().hasData()) allocationPartyReference = null;
			if (allocationAccountReference!=null && !allocationAccountReference.prune().hasData()) allocationAccountReference = null;
			proposedCollateralAllocationChoice = proposedCollateralAllocationChoice.stream().filter(b->b!=null).<ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationPartyReference()!=null && getAllocationPartyReference().hasData()) return true;
			if (getAllocationAccountReference()!=null && getAllocationAccountReference().hasData()) return true;
			if (getProposedCollateralAllocationChoice()!=null && getProposedCollateralAllocationChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProposedCollateralAllocation.ProposedCollateralAllocationBuilder o = (ProposedCollateralAllocation.ProposedCollateralAllocationBuilder) other;
			
			merger.mergeRosetta(getAllocationPartyReference(), o.getAllocationPartyReference(), this::setAllocationPartyReference);
			merger.mergeRosetta(getAllocationAccountReference(), o.getAllocationAccountReference(), this::setAllocationAccountReference);
			merger.mergeRosetta(getProposedCollateralAllocationChoice(), o.getProposedCollateralAllocationChoice(), this::getOrCreateProposedCollateralAllocationChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(allocationPartyReference, _that.getAllocationPartyReference())) return false;
			if (!Objects.equals(allocationAccountReference, _that.getAllocationAccountReference())) return false;
			if (!ListEquals.listEquals(proposedCollateralAllocationChoice, _that.getProposedCollateralAllocationChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationPartyReference != null ? allocationPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocationAccountReference != null ? allocationAccountReference.hashCode() : 0);
			_result = 31 * _result + (proposedCollateralAllocationChoice != null ? proposedCollateralAllocationChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedCollateralAllocationBuilder {" +
				"allocationPartyReference=" + this.allocationPartyReference + ", " +
				"allocationAccountReference=" + this.allocationAccountReference + ", " +
				"proposedCollateralAllocationChoice=" + this.proposedCollateralAllocationChoice +
			'}';
		}
	}
}
