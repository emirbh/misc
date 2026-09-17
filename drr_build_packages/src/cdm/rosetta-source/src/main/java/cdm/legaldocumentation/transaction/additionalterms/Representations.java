package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.meta.RepresentationsMeta;
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
 * @version 6.23.0
 */
@RosettaDataType(value="Representations", builder=Representations.RepresentationsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Representations", model="cdm", builder=Representations.RepresentationsBuilderImpl.class, version="6.23.0")
public interface Representations extends RosettaModelObject {

	RepresentationsMeta metaData = new RepresentationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, then non reliance is applicable.
	 */
	Boolean getNonReliance();
	/**
	 * If true, then agreements regarding hedging are applicable.
	 */
	Boolean getAgreementsRegardingHedging();
	/**
	 * If present and true, then index disclaimer is applicable.
	 */
	Boolean getIndexDisclaimer();
	/**
	 * If true, then additional acknowledgements are applicable.
	 */
	Boolean getAdditionalAcknowledgements();
	List<? extends Clause> getAdditionalBespokeTerms();

	/*********************** Build Methods  ***********************/
	Representations build();
	
	Representations.RepresentationsBuilder toBuilder();
	
	static Representations.RepresentationsBuilder builder() {
		return new Representations.RepresentationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Representations> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Representations> getType() {
		return Representations.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nonReliance"), Boolean.class, getNonReliance(), this);
		processor.processBasic(path.newSubPath("agreementsRegardingHedging"), Boolean.class, getAgreementsRegardingHedging(), this);
		processor.processBasic(path.newSubPath("indexDisclaimer"), Boolean.class, getIndexDisclaimer(), this);
		processor.processBasic(path.newSubPath("additionalAcknowledgements"), Boolean.class, getAdditionalAcknowledgements(), this);
		processRosetta(path.newSubPath("additionalBespokeTerms"), processor, Clause.class, getAdditionalBespokeTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepresentationsBuilder extends Representations, RosettaModelObjectBuilder {
		Clause.ClauseBuilder getOrCreateAdditionalBespokeTerms(int index);
		@Override
		List<? extends Clause.ClauseBuilder> getAdditionalBespokeTerms();
		Representations.RepresentationsBuilder setNonReliance(Boolean nonReliance);
		Representations.RepresentationsBuilder setAgreementsRegardingHedging(Boolean agreementsRegardingHedging);
		Representations.RepresentationsBuilder setIndexDisclaimer(Boolean indexDisclaimer);
		Representations.RepresentationsBuilder setAdditionalAcknowledgements(Boolean additionalAcknowledgements);
		Representations.RepresentationsBuilder addAdditionalBespokeTerms(Clause additionalBespokeTerms);
		Representations.RepresentationsBuilder addAdditionalBespokeTerms(Clause additionalBespokeTerms, int idx);
		Representations.RepresentationsBuilder addAdditionalBespokeTerms(List<? extends Clause> additionalBespokeTerms);
		Representations.RepresentationsBuilder setAdditionalBespokeTerms(List<? extends Clause> additionalBespokeTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nonReliance"), Boolean.class, getNonReliance(), this);
			processor.processBasic(path.newSubPath("agreementsRegardingHedging"), Boolean.class, getAgreementsRegardingHedging(), this);
			processor.processBasic(path.newSubPath("indexDisclaimer"), Boolean.class, getIndexDisclaimer(), this);
			processor.processBasic(path.newSubPath("additionalAcknowledgements"), Boolean.class, getAdditionalAcknowledgements(), this);
			processRosetta(path.newSubPath("additionalBespokeTerms"), processor, Clause.ClauseBuilder.class, getAdditionalBespokeTerms());
		}
		

		Representations.RepresentationsBuilder prune();
	}

	/*********************** Immutable Implementation of Representations  ***********************/
	class RepresentationsImpl implements Representations {
		private final Boolean nonReliance;
		private final Boolean agreementsRegardingHedging;
		private final Boolean indexDisclaimer;
		private final Boolean additionalAcknowledgements;
		private final List<? extends Clause> additionalBespokeTerms;
		
		protected RepresentationsImpl(Representations.RepresentationsBuilder builder) {
			this.nonReliance = builder.getNonReliance();
			this.agreementsRegardingHedging = builder.getAgreementsRegardingHedging();
			this.indexDisclaimer = builder.getIndexDisclaimer();
			this.additionalAcknowledgements = builder.getAdditionalAcknowledgements();
			this.additionalBespokeTerms = ofNullable(builder.getAdditionalBespokeTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonReliance")
		public Boolean getNonReliance() {
			return nonReliance;
		}
		
		@Override
		@RosettaAttribute("agreementsRegardingHedging")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agreementsRegardingHedging")
		public Boolean getAgreementsRegardingHedging() {
			return agreementsRegardingHedging;
		}
		
		@Override
		@RosettaAttribute("indexDisclaimer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexDisclaimer")
		public Boolean getIndexDisclaimer() {
			return indexDisclaimer;
		}
		
		@Override
		@RosettaAttribute("additionalAcknowledgements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalAcknowledgements")
		public Boolean getAdditionalAcknowledgements() {
			return additionalAcknowledgements;
		}
		
		@Override
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalBespokeTerms")
		public List<? extends Clause> getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		public Representations build() {
			return this;
		}
		
		@Override
		public Representations.RepresentationsBuilder toBuilder() {
			Representations.RepresentationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Representations.RepresentationsBuilder builder) {
			ofNullable(getNonReliance()).ifPresent(builder::setNonReliance);
			ofNullable(getAgreementsRegardingHedging()).ifPresent(builder::setAgreementsRegardingHedging);
			ofNullable(getIndexDisclaimer()).ifPresent(builder::setIndexDisclaimer);
			ofNullable(getAdditionalAcknowledgements()).ifPresent(builder::setAdditionalAcknowledgements);
			ofNullable(getAdditionalBespokeTerms()).ifPresent(builder::setAdditionalBespokeTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Representations _that = getType().cast(o);
		
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(agreementsRegardingHedging, _that.getAgreementsRegardingHedging())) return false;
			if (!Objects.equals(indexDisclaimer, _that.getIndexDisclaimer())) return false;
			if (!Objects.equals(additionalAcknowledgements, _that.getAdditionalAcknowledgements())) return false;
			if (!ListEquals.listEquals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (agreementsRegardingHedging != null ? agreementsRegardingHedging.hashCode() : 0);
			_result = 31 * _result + (indexDisclaimer != null ? indexDisclaimer.hashCode() : 0);
			_result = 31 * _result + (additionalAcknowledgements != null ? additionalAcknowledgements.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Representations {" +
				"nonReliance=" + this.nonReliance + ", " +
				"agreementsRegardingHedging=" + this.agreementsRegardingHedging + ", " +
				"indexDisclaimer=" + this.indexDisclaimer + ", " +
				"additionalAcknowledgements=" + this.additionalAcknowledgements + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of Representations  ***********************/
	class RepresentationsBuilderImpl implements Representations.RepresentationsBuilder {
	
		protected Boolean nonReliance;
		protected Boolean agreementsRegardingHedging;
		protected Boolean indexDisclaimer;
		protected Boolean additionalAcknowledgements;
		protected List<Clause.ClauseBuilder> additionalBespokeTerms = new ArrayList<>();
		
		@Override
		@RosettaAttribute("nonReliance")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonReliance")
		public Boolean getNonReliance() {
			return nonReliance;
		}
		
		@Override
		@RosettaAttribute("agreementsRegardingHedging")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agreementsRegardingHedging")
		public Boolean getAgreementsRegardingHedging() {
			return agreementsRegardingHedging;
		}
		
		@Override
		@RosettaAttribute("indexDisclaimer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexDisclaimer")
		public Boolean getIndexDisclaimer() {
			return indexDisclaimer;
		}
		
		@Override
		@RosettaAttribute("additionalAcknowledgements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalAcknowledgements")
		public Boolean getAdditionalAcknowledgements() {
			return additionalAcknowledgements;
		}
		
		@Override
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalBespokeTerms")
		public List<? extends Clause.ClauseBuilder> getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		public Clause.ClauseBuilder getOrCreateAdditionalBespokeTerms(int index) {
			if (additionalBespokeTerms==null) {
				this.additionalBespokeTerms = new ArrayList<>();
			}
			return getIndex(additionalBespokeTerms, index, () -> {
						Clause.ClauseBuilder newAdditionalBespokeTerms = Clause.builder();
						return newAdditionalBespokeTerms;
					});
		}
		
		@RosettaAttribute("nonReliance")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nonReliance")
		@Override
		public Representations.RepresentationsBuilder setNonReliance(Boolean _nonReliance) {
			this.nonReliance = _nonReliance == null ? null : _nonReliance;
			return this;
		}
		
		@RosettaAttribute("agreementsRegardingHedging")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agreementsRegardingHedging")
		@Override
		public Representations.RepresentationsBuilder setAgreementsRegardingHedging(Boolean _agreementsRegardingHedging) {
			this.agreementsRegardingHedging = _agreementsRegardingHedging == null ? null : _agreementsRegardingHedging;
			return this;
		}
		
		@RosettaAttribute("indexDisclaimer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexDisclaimer")
		@Override
		public Representations.RepresentationsBuilder setIndexDisclaimer(Boolean _indexDisclaimer) {
			this.indexDisclaimer = _indexDisclaimer == null ? null : _indexDisclaimer;
			return this;
		}
		
		@RosettaAttribute("additionalAcknowledgements")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalAcknowledgements")
		@Override
		public Representations.RepresentationsBuilder setAdditionalAcknowledgements(Boolean _additionalAcknowledgements) {
			this.additionalAcknowledgements = _additionalAcknowledgements == null ? null : _additionalAcknowledgements;
			return this;
		}
		
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalBespokeTerms")
		@Override
		public Representations.RepresentationsBuilder addAdditionalBespokeTerms(Clause _additionalBespokeTerms) {
			if (_additionalBespokeTerms != null) {
				this.additionalBespokeTerms.add(_additionalBespokeTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public Representations.RepresentationsBuilder addAdditionalBespokeTerms(Clause _additionalBespokeTerms, int idx) {
			getIndex(this.additionalBespokeTerms, idx, () -> _additionalBespokeTerms.toBuilder());
			return this;
		}
		
		@Override
		public Representations.RepresentationsBuilder addAdditionalBespokeTerms(List<? extends Clause> additionalBespokeTermss) {
			if (additionalBespokeTermss != null) {
				for (final Clause toAdd : additionalBespokeTermss) {
					this.additionalBespokeTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalBespokeTerms")
		@Override
		public Representations.RepresentationsBuilder setAdditionalBespokeTerms(List<? extends Clause> additionalBespokeTermss) {
			if (additionalBespokeTermss == null) {
				this.additionalBespokeTerms = new ArrayList<>();
			} else {
				this.additionalBespokeTerms = additionalBespokeTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Representations build() {
			return new Representations.RepresentationsImpl(this);
		}
		
		@Override
		public Representations.RepresentationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Representations.RepresentationsBuilder prune() {
			additionalBespokeTerms = additionalBespokeTerms.stream().filter(b->b!=null).<Clause.ClauseBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonReliance()!=null) return true;
			if (getAgreementsRegardingHedging()!=null) return true;
			if (getIndexDisclaimer()!=null) return true;
			if (getAdditionalAcknowledgements()!=null) return true;
			if (getAdditionalBespokeTerms()!=null && getAdditionalBespokeTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Representations.RepresentationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Representations.RepresentationsBuilder o = (Representations.RepresentationsBuilder) other;
			
			merger.mergeRosetta(getAdditionalBespokeTerms(), o.getAdditionalBespokeTerms(), this::getOrCreateAdditionalBespokeTerms);
			
			merger.mergeBasic(getNonReliance(), o.getNonReliance(), this::setNonReliance);
			merger.mergeBasic(getAgreementsRegardingHedging(), o.getAgreementsRegardingHedging(), this::setAgreementsRegardingHedging);
			merger.mergeBasic(getIndexDisclaimer(), o.getIndexDisclaimer(), this::setIndexDisclaimer);
			merger.mergeBasic(getAdditionalAcknowledgements(), o.getAdditionalAcknowledgements(), this::setAdditionalAcknowledgements);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Representations _that = getType().cast(o);
		
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(agreementsRegardingHedging, _that.getAgreementsRegardingHedging())) return false;
			if (!Objects.equals(indexDisclaimer, _that.getIndexDisclaimer())) return false;
			if (!Objects.equals(additionalAcknowledgements, _that.getAdditionalAcknowledgements())) return false;
			if (!ListEquals.listEquals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (agreementsRegardingHedging != null ? agreementsRegardingHedging.hashCode() : 0);
			_result = 31 * _result + (indexDisclaimer != null ? indexDisclaimer.hashCode() : 0);
			_result = 31 * _result + (additionalAcknowledgements != null ? additionalAcknowledgements.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepresentationsBuilder {" +
				"nonReliance=" + this.nonReliance + ", " +
				"agreementsRegardingHedging=" + this.agreementsRegardingHedging + ", " +
				"indexDisclaimer=" + this.indexDisclaimer + ", " +
				"additionalAcknowledgements=" + this.additionalAcknowledgements + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms +
			'}';
		}
	}
}
