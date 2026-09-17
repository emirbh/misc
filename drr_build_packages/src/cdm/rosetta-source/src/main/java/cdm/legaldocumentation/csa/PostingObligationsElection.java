package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.PostingObligationsElectionMeta;
import cdm.product.collateral.EligibleCollateralCriteria;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the collateral posting obligations for the security provider party(ies).
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(ii)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="PostingObligationsElection", builder=PostingObligationsElection.PostingObligationsElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PostingObligationsElection", model="cdm", builder=PostingObligationsElection.PostingObligationsElectionBuilderImpl.class, version="6.23.0")
public interface PostingObligationsElection extends RosettaModelObject {

	PostingObligationsElectionMeta metaData = new PostingObligationsElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * If set to True, the Control Agreement is a Credit Support Document with respect to the party(ies).
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "6" * clause "(e)"
	 *
	 * Provision 
	 *
	 */
	Boolean getAsPermitted();
	/**
	 * The eligible collateral as specified in relation to the pledgor/chargor/obligor(s) posting obligation.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * name "Eligible Credit Support (IM) Schedule"
	 *
	 * Provision 
	 *
	 */
	List<? extends EligibleCollateralCriteria> getEligibleCollateral();
	/**
	 * The excluded collateral as specified in relation to the pledgor/chargor/obligor(s) posting obligation.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(ii)(B)(i)"
	 *
	 * Provision 
	 *
	 */
	String getExcludedCollateral();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	PostingObligationsElection build();
	
	PostingObligationsElection.PostingObligationsElectionBuilder toBuilder();
	
	static PostingObligationsElection.PostingObligationsElectionBuilder builder() {
		return new PostingObligationsElection.PostingObligationsElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostingObligationsElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PostingObligationsElection> getType() {
		return PostingObligationsElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("asPermitted"), Boolean.class, getAsPermitted(), this);
		processRosetta(path.newSubPath("eligibleCollateral"), processor, EligibleCollateralCriteria.class, getEligibleCollateral());
		processor.processBasic(path.newSubPath("excludedCollateral"), String.class, getExcludedCollateral(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostingObligationsElectionBuilder extends PostingObligationsElection, RosettaModelObjectBuilder {
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateEligibleCollateral(int index);
		@Override
		List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getEligibleCollateral();
		PostingObligationsElection.PostingObligationsElectionBuilder setParty(CounterpartyRoleEnum party);
		PostingObligationsElection.PostingObligationsElectionBuilder setAsPermitted(Boolean asPermitted);
		PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralCriteria eligibleCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralCriteria eligibleCollateral, int idx);
		PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(List<? extends EligibleCollateralCriteria> eligibleCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder setEligibleCollateral(List<? extends EligibleCollateralCriteria> eligibleCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder setExcludedCollateral(String excludedCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("asPermitted"), Boolean.class, getAsPermitted(), this);
			processRosetta(path.newSubPath("eligibleCollateral"), processor, EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder.class, getEligibleCollateral());
			processor.processBasic(path.newSubPath("excludedCollateral"), String.class, getExcludedCollateral(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		PostingObligationsElection.PostingObligationsElectionBuilder prune();
	}

	/*********************** Immutable Implementation of PostingObligationsElection  ***********************/
	class PostingObligationsElectionImpl implements PostingObligationsElection {
		private final CounterpartyRoleEnum party;
		private final Boolean asPermitted;
		private final List<? extends EligibleCollateralCriteria> eligibleCollateral;
		private final String excludedCollateral;
		private final String additionalLanguage;
		
		protected PostingObligationsElectionImpl(PostingObligationsElection.PostingObligationsElectionBuilder builder) {
			this.party = builder.getParty();
			this.asPermitted = builder.getAsPermitted();
			this.eligibleCollateral = ofNullable(builder.getEligibleCollateral()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.excludedCollateral = builder.getExcludedCollateral();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("asPermitted")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asPermitted")
		public Boolean getAsPermitted() {
			return asPermitted;
		}
		
		@Override
		@RosettaAttribute("eligibleCollateral")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eligibleCollateral")
		public List<? extends EligibleCollateralCriteria> getEligibleCollateral() {
			return eligibleCollateral;
		}
		
		@Override
		@RosettaAttribute("excludedCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excludedCollateral")
		public String getExcludedCollateral() {
			return excludedCollateral;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public PostingObligationsElection build() {
			return this;
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder toBuilder() {
			PostingObligationsElection.PostingObligationsElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostingObligationsElection.PostingObligationsElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAsPermitted()).ifPresent(builder::setAsPermitted);
			ofNullable(getEligibleCollateral()).ifPresent(builder::setEligibleCollateral);
			ofNullable(getExcludedCollateral()).ifPresent(builder::setExcludedCollateral);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostingObligationsElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(asPermitted, _that.getAsPermitted())) return false;
			if (!ListEquals.listEquals(eligibleCollateral, _that.getEligibleCollateral())) return false;
			if (!Objects.equals(excludedCollateral, _that.getExcludedCollateral())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asPermitted != null ? asPermitted.hashCode() : 0);
			_result = 31 * _result + (eligibleCollateral != null ? eligibleCollateral.hashCode() : 0);
			_result = 31 * _result + (excludedCollateral != null ? excludedCollateral.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostingObligationsElection {" +
				"party=" + this.party + ", " +
				"asPermitted=" + this.asPermitted + ", " +
				"eligibleCollateral=" + this.eligibleCollateral + ", " +
				"excludedCollateral=" + this.excludedCollateral + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of PostingObligationsElection  ***********************/
	class PostingObligationsElectionBuilderImpl implements PostingObligationsElection.PostingObligationsElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean asPermitted;
		protected List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> eligibleCollateral = new ArrayList<>();
		protected String excludedCollateral;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("asPermitted")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asPermitted")
		public Boolean getAsPermitted() {
			return asPermitted;
		}
		
		@Override
		@RosettaAttribute("eligibleCollateral")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eligibleCollateral")
		public List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getEligibleCollateral() {
			return eligibleCollateral;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateEligibleCollateral(int index) {
			if (eligibleCollateral==null) {
				this.eligibleCollateral = new ArrayList<>();
			}
			return getIndex(eligibleCollateral, index, () -> {
						EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder newEligibleCollateral = EligibleCollateralCriteria.builder();
						return newEligibleCollateral;
					});
		}
		
		@Override
		@RosettaAttribute("excludedCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excludedCollateral")
		public String getExcludedCollateral() {
			return excludedCollateral;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("asPermitted")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("asPermitted")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setAsPermitted(Boolean _asPermitted) {
			this.asPermitted = _asPermitted == null ? null : _asPermitted;
			return this;
		}
		
		@RosettaAttribute("eligibleCollateral")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eligibleCollateral")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralCriteria _eligibleCollateral) {
			if (_eligibleCollateral != null) {
				this.eligibleCollateral.add(_eligibleCollateral.toBuilder());
			}
			return this;
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralCriteria _eligibleCollateral, int idx) {
			getIndex(this.eligibleCollateral, idx, () -> _eligibleCollateral.toBuilder());
			return this;
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(List<? extends EligibleCollateralCriteria> eligibleCollaterals) {
			if (eligibleCollaterals != null) {
				for (final EligibleCollateralCriteria toAdd : eligibleCollaterals) {
					this.eligibleCollateral.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eligibleCollateral")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eligibleCollateral")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setEligibleCollateral(List<? extends EligibleCollateralCriteria> eligibleCollaterals) {
			if (eligibleCollaterals == null) {
				this.eligibleCollateral = new ArrayList<>();
			} else {
				this.eligibleCollateral = eligibleCollaterals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("excludedCollateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excludedCollateral")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setExcludedCollateral(String _excludedCollateral) {
			this.excludedCollateral = _excludedCollateral == null ? null : _excludedCollateral;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public PostingObligationsElection build() {
			return new PostingObligationsElection.PostingObligationsElectionImpl(this);
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder prune() {
			eligibleCollateral = eligibleCollateral.stream().filter(b->b!=null).<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getAsPermitted()!=null) return true;
			if (getEligibleCollateral()!=null && getEligibleCollateral().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExcludedCollateral()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostingObligationsElection.PostingObligationsElectionBuilder o = (PostingObligationsElection.PostingObligationsElectionBuilder) other;
			
			merger.mergeRosetta(getEligibleCollateral(), o.getEligibleCollateral(), this::getOrCreateEligibleCollateral);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getAsPermitted(), o.getAsPermitted(), this::setAsPermitted);
			merger.mergeBasic(getExcludedCollateral(), o.getExcludedCollateral(), this::setExcludedCollateral);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostingObligationsElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(asPermitted, _that.getAsPermitted())) return false;
			if (!ListEquals.listEquals(eligibleCollateral, _that.getEligibleCollateral())) return false;
			if (!Objects.equals(excludedCollateral, _that.getExcludedCollateral())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asPermitted != null ? asPermitted.hashCode() : 0);
			_result = 31 * _result + (eligibleCollateral != null ? eligibleCollateral.hashCode() : 0);
			_result = 31 * _result + (excludedCollateral != null ? excludedCollateral.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostingObligationsElectionBuilder {" +
				"party=" + this.party + ", " +
				"asPermitted=" + this.asPermitted + ", " +
				"eligibleCollateral=" + this.eligibleCollateral + ", " +
				"excludedCollateral=" + this.excludedCollateral + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
