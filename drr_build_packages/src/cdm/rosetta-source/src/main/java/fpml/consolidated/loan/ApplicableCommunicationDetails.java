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
import fpml.consolidated.loan.meta.ApplicableCommunicationDetailsMeta;
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
 * Provision A structure that defines the assets (or type of assets) that a particular set of communication details may be associated with.
 *
 */
@RosettaDataType(value="ApplicableCommunicationDetails", builder=ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApplicableCommunicationDetails", model="fpml", builder=ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilderImpl.class, version="2.1.1")
public interface ApplicableCommunicationDetails extends AbstractApplicablePartyProfileObjects {

	ApplicableCommunicationDetailsMeta metaData = new ApplicableCommunicationDetailsMeta();

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
	List<? extends ApplicableCommunicationDetailsChoice> getApplicableCommunicationDetailsChoice();

	/*********************** Build Methods  ***********************/
	ApplicableCommunicationDetails build();
	
	ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder toBuilder();
	
	static ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder() {
		return new ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableCommunicationDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableCommunicationDetails> getType() {
		return ApplicableCommunicationDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.class, getApplicableAssets());
		processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactions.class, getApplicableTransactions());
		processRosetta(path.newSubPath("applicableCommunicationDetailsChoice"), processor, ApplicableCommunicationDetailsChoice.class, getApplicableCommunicationDetailsChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableCommunicationDetailsBuilder extends ApplicableCommunicationDetails, AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder {
		ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder getOrCreateApplicableCommunicationDetailsChoice(int index);
		@Override
		List<? extends ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder> getApplicableCommunicationDetailsChoice();
		@Override
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setIdentifier(AssociationToAssetIdentifier identifier);
		@Override
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableAssets(ApplicableAssets applicableAssets);
		@Override
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableTransactions(ApplicableTransactions applicableTransactions);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableCommunicationDetailsChoice(ApplicableCommunicationDetailsChoice applicableCommunicationDetailsChoice);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableCommunicationDetailsChoice(ApplicableCommunicationDetailsChoice applicableCommunicationDetailsChoice, int idx);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableCommunicationDetailsChoice(List<? extends ApplicableCommunicationDetailsChoice> applicableCommunicationDetailsChoice);
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableCommunicationDetailsChoice(List<? extends ApplicableCommunicationDetailsChoice> applicableCommunicationDetailsChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.ApplicableAssetsBuilder.class, getApplicableAssets());
			processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactions.ApplicableTransactionsBuilder.class, getApplicableTransactions());
			processRosetta(path.newSubPath("applicableCommunicationDetailsChoice"), processor, ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder.class, getApplicableCommunicationDetailsChoice());
		}
		

		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableCommunicationDetails  ***********************/
	class ApplicableCommunicationDetailsImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl implements ApplicableCommunicationDetails {
		private final List<? extends ApplicableCommunicationDetailsChoice> applicableCommunicationDetailsChoice;
		
		protected ApplicableCommunicationDetailsImpl(ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder) {
			super(builder);
			this.applicableCommunicationDetailsChoice = ofNullable(builder.getApplicableCommunicationDetailsChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicableCommunicationDetailsChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("applicableCommunicationDetailsChoice")
		public List<? extends ApplicableCommunicationDetailsChoice> getApplicableCommunicationDetailsChoice() {
			return applicableCommunicationDetailsChoice;
		}
		
		@Override
		public ApplicableCommunicationDetails build() {
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder toBuilder() {
			ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getApplicableCommunicationDetailsChoice()).ifPresent(builder::setApplicableCommunicationDetailsChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableCommunicationDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableCommunicationDetailsChoice, _that.getApplicableCommunicationDetailsChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (applicableCommunicationDetailsChoice != null ? applicableCommunicationDetailsChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableCommunicationDetails {" +
				"applicableCommunicationDetailsChoice=" + this.applicableCommunicationDetailsChoice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ApplicableCommunicationDetails  ***********************/
	class ApplicableCommunicationDetailsBuilderImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl implements ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder {
	
		protected List<ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder> applicableCommunicationDetailsChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("applicableCommunicationDetailsChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("applicableCommunicationDetailsChoice")
		public List<? extends ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder> getApplicableCommunicationDetailsChoice() {
			return applicableCommunicationDetailsChoice;
		}
		
		@Override
		public ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder getOrCreateApplicableCommunicationDetailsChoice(int index) {
			if (applicableCommunicationDetailsChoice==null) {
				this.applicableCommunicationDetailsChoice = new ArrayList<>();
			}
			return getIndex(applicableCommunicationDetailsChoice, index, () -> {
						ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder newApplicableCommunicationDetailsChoice = ApplicableCommunicationDetailsChoice.builder();
						return newApplicableCommunicationDetailsChoice;
					});
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("identifier")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setIdentifier(AssociationToAssetIdentifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("applicableAssets")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("applicableAssets")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableAssets(ApplicableAssets _applicableAssets) {
			this.applicableAssets = _applicableAssets == null ? null : _applicableAssets.toBuilder();
			return this;
		}
		
		@RosettaAttribute("applicableTransactions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("applicableTransactions")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableTransactions(ApplicableTransactions _applicableTransactions) {
			this.applicableTransactions = _applicableTransactions == null ? null : _applicableTransactions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("applicableCommunicationDetailsChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("applicableCommunicationDetailsChoice")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableCommunicationDetailsChoice(ApplicableCommunicationDetailsChoice _applicableCommunicationDetailsChoice) {
			if (_applicableCommunicationDetailsChoice != null) {
				this.applicableCommunicationDetailsChoice.add(_applicableCommunicationDetailsChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableCommunicationDetailsChoice(ApplicableCommunicationDetailsChoice _applicableCommunicationDetailsChoice, int idx) {
			getIndex(this.applicableCommunicationDetailsChoice, idx, () -> _applicableCommunicationDetailsChoice.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder addApplicableCommunicationDetailsChoice(List<? extends ApplicableCommunicationDetailsChoice> applicableCommunicationDetailsChoices) {
			if (applicableCommunicationDetailsChoices != null) {
				for (final ApplicableCommunicationDetailsChoice toAdd : applicableCommunicationDetailsChoices) {
					this.applicableCommunicationDetailsChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("applicableCommunicationDetailsChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("applicableCommunicationDetailsChoice")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder setApplicableCommunicationDetailsChoice(List<? extends ApplicableCommunicationDetailsChoice> applicableCommunicationDetailsChoices) {
			if (applicableCommunicationDetailsChoices == null) {
				this.applicableCommunicationDetailsChoice = new ArrayList<>();
			} else {
				this.applicableCommunicationDetailsChoice = applicableCommunicationDetailsChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetails build() {
			return new ApplicableCommunicationDetails.ApplicableCommunicationDetailsImpl(this);
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder prune() {
			super.prune();
			applicableCommunicationDetailsChoice = applicableCommunicationDetailsChoice.stream().filter(b->b!=null).<ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getApplicableCommunicationDetailsChoice()!=null && getApplicableCommunicationDetailsChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder o = (ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder) other;
			
			merger.mergeRosetta(getApplicableCommunicationDetailsChoice(), o.getApplicableCommunicationDetailsChoice(), this::getOrCreateApplicableCommunicationDetailsChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableCommunicationDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableCommunicationDetailsChoice, _that.getApplicableCommunicationDetailsChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (applicableCommunicationDetailsChoice != null ? applicableCommunicationDetailsChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableCommunicationDetailsBuilder {" +
				"applicableCommunicationDetailsChoice=" + this.applicableCommunicationDetailsChoice +
			'}' + " " + super.toString();
		}
	}
}
