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
import fpml.consolidated.loan.meta.ApplicableSettlementInstructionDetailsMeta;
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
 * Provision A structure that defines the assets (or type of assets) that a particular set of settlement instrution details may be associated with.
 *
 */
@RosettaDataType(value="ApplicableSettlementInstructionDetails", builder=ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApplicableSettlementInstructionDetails", model="fpml", builder=ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilderImpl.class, version="2.1.1")
public interface ApplicableSettlementInstructionDetails extends AbstractApplicablePartyProfileObjects {

	ApplicableSettlementInstructionDetailsMeta metaData = new ApplicableSettlementInstructionDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement account details to describe the acount to which cash should be sent, for payments received by the party sending the Lender Party Notification.
	 *
	 */
	List<? extends SettlementDetails> getSettlementDetails();

	/*********************** Build Methods  ***********************/
	ApplicableSettlementInstructionDetails build();
	
	ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder toBuilder();
	
	static ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder() {
		return new ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableSettlementInstructionDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableSettlementInstructionDetails> getType() {
		return ApplicableSettlementInstructionDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.class, getApplicableAssets());
		processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactions.class, getApplicableTransactions());
		processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.class, getSettlementDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableSettlementInstructionDetailsBuilder extends ApplicableSettlementInstructionDetails, AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder {
		SettlementDetails.SettlementDetailsBuilder getOrCreateSettlementDetails(int index);
		@Override
		List<? extends SettlementDetails.SettlementDetailsBuilder> getSettlementDetails();
		@Override
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setIdentifier(AssociationToAssetIdentifier identifier);
		@Override
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableAssets(ApplicableAssets applicableAssets);
		@Override
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableTransactions(ApplicableTransactions applicableTransactions);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails settlementDetails);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails settlementDetails, int idx);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetails);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.ApplicableAssetsBuilder.class, getApplicableAssets());
			processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactions.ApplicableTransactionsBuilder.class, getApplicableTransactions());
			processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.SettlementDetailsBuilder.class, getSettlementDetails());
		}
		

		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableSettlementInstructionDetails  ***********************/
	class ApplicableSettlementInstructionDetailsImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl implements ApplicableSettlementInstructionDetails {
		private final List<? extends SettlementDetails> settlementDetails;
		
		protected ApplicableSettlementInstructionDetailsImpl(ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder) {
			super(builder);
			this.settlementDetails = ofNullable(builder.getSettlementDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementDetails")
		public List<? extends SettlementDetails> getSettlementDetails() {
			return settlementDetails;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails build() {
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder toBuilder() {
			ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementDetails()).ifPresent(builder::setSettlementDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableSettlementInstructionDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableSettlementInstructionDetails {" +
				"settlementDetails=" + this.settlementDetails +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ApplicableSettlementInstructionDetails  ***********************/
	class ApplicableSettlementInstructionDetailsBuilderImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl implements ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder {
	
		protected List<SettlementDetails.SettlementDetailsBuilder> settlementDetails = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementDetails")
		public List<? extends SettlementDetails.SettlementDetailsBuilder> getSettlementDetails() {
			return settlementDetails;
		}
		
		@Override
		public SettlementDetails.SettlementDetailsBuilder getOrCreateSettlementDetails(int index) {
			if (settlementDetails==null) {
				this.settlementDetails = new ArrayList<>();
			}
			return getIndex(settlementDetails, index, () -> {
						SettlementDetails.SettlementDetailsBuilder newSettlementDetails = SettlementDetails.builder();
						return newSettlementDetails;
					});
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("identifier")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setIdentifier(AssociationToAssetIdentifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("applicableAssets")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("applicableAssets")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableAssets(ApplicableAssets _applicableAssets) {
			this.applicableAssets = _applicableAssets == null ? null : _applicableAssets.toBuilder();
			return this;
		}
		
		@RosettaAttribute("applicableTransactions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("applicableTransactions")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableTransactions(ApplicableTransactions _applicableTransactions) {
			this.applicableTransactions = _applicableTransactions == null ? null : _applicableTransactions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("settlementDetails")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails _settlementDetails) {
			if (_settlementDetails != null) {
				this.settlementDetails.add(_settlementDetails.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails _settlementDetails, int idx) {
			getIndex(this.settlementDetails, idx, () -> _settlementDetails.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
			if (settlementDetailss != null) {
				for (final SettlementDetails toAdd : settlementDetailss) {
					this.settlementDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("settlementDetails")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
			if (settlementDetailss == null) {
				this.settlementDetails = new ArrayList<>();
			} else {
				this.settlementDetails = settlementDetailss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails build() {
			return new ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsImpl(this);
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder prune() {
			super.prune();
			settlementDetails = settlementDetails.stream().filter(b->b!=null).<SettlementDetails.SettlementDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementDetails()!=null && getSettlementDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder o = (ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder) other;
			
			merger.mergeRosetta(getSettlementDetails(), o.getSettlementDetails(), this::getOrCreateSettlementDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableSettlementInstructionDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableSettlementInstructionDetailsBuilder {" +
				"settlementDetails=" + this.settlementDetails +
			'}' + " " + super.toString();
		}
	}
}
