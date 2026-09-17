package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.SubstitutedRegimeMeta;
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
 * A class to specify each party&#39;s election with respect to the Substituted Regimes that will be applicable...
 * @version 6.23.0
 */
@RosettaDataType(value="SubstitutedRegime", builder=SubstitutedRegime.SubstitutedRegimeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SubstitutedRegime", model="cdm", builder=SubstitutedRegime.SubstitutedRegimeBuilderImpl.class, version="6.23.0")
public interface SubstitutedRegime extends RosettaModelObject {

	SubstitutedRegimeMeta metaData = new SubstitutedRegimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The applicable regulatory regime, as specified through an enumeration.
	 */
	RegulatoryRegimeEnum getRegime();
	/**
	 * The additional regulatory regime as specified by the parties.
	 */
	String getAdditionalRegime();
	/**
	 * Specifies the applicability of the Substituted Regime as denoted in the Substituted Regime Table as part of certain legal agreements, such as the ISDA 2016 and 2018 CSA for Initial Margin.
	 */
	List<? extends SubstitutedRegimeTerms> getRegimeTerms();

	/*********************** Build Methods  ***********************/
	SubstitutedRegime build();
	
	SubstitutedRegime.SubstitutedRegimeBuilder toBuilder();
	
	static SubstitutedRegime.SubstitutedRegimeBuilder builder() {
		return new SubstitutedRegime.SubstitutedRegimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SubstitutedRegime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SubstitutedRegime> getType() {
		return SubstitutedRegime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
		processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
		processRosetta(path.newSubPath("regimeTerms"), processor, SubstitutedRegimeTerms.class, getRegimeTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SubstitutedRegimeBuilder extends SubstitutedRegime, RosettaModelObjectBuilder {
		SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder getOrCreateRegimeTerms(int index);
		@Override
		List<? extends SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder> getRegimeTerms();
		SubstitutedRegime.SubstitutedRegimeBuilder setRegime(RegulatoryRegimeEnum regime);
		SubstitutedRegime.SubstitutedRegimeBuilder setAdditionalRegime(String additionalRegime);
		SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms regimeTerms);
		SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms regimeTerms, int idx);
		SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTerms);
		SubstitutedRegime.SubstitutedRegimeBuilder setRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
			processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
			processRosetta(path.newSubPath("regimeTerms"), processor, SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder.class, getRegimeTerms());
		}
		

		SubstitutedRegime.SubstitutedRegimeBuilder prune();
	}

	/*********************** Immutable Implementation of SubstitutedRegime  ***********************/
	class SubstitutedRegimeImpl implements SubstitutedRegime {
		private final RegulatoryRegimeEnum regime;
		private final String additionalRegime;
		private final List<? extends SubstitutedRegimeTerms> regimeTerms;
		
		protected SubstitutedRegimeImpl(SubstitutedRegime.SubstitutedRegimeBuilder builder) {
			this.regime = builder.getRegime();
			this.additionalRegime = builder.getAdditionalRegime();
			this.regimeTerms = ofNullable(builder.getRegimeTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regime")
		public RegulatoryRegimeEnum getRegime() {
			return regime;
		}
		
		@Override
		@RosettaAttribute("additionalRegime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalRegime")
		public String getAdditionalRegime() {
			return additionalRegime;
		}
		
		@Override
		@RosettaAttribute("regimeTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("regimeTerms")
		public List<? extends SubstitutedRegimeTerms> getRegimeTerms() {
			return regimeTerms;
		}
		
		@Override
		public SubstitutedRegime build() {
			return this;
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder toBuilder() {
			SubstitutedRegime.SubstitutedRegimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SubstitutedRegime.SubstitutedRegimeBuilder builder) {
			ofNullable(getRegime()).ifPresent(builder::setRegime);
			ofNullable(getAdditionalRegime()).ifPresent(builder::setAdditionalRegime);
			ofNullable(getRegimeTerms()).ifPresent(builder::setRegimeTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegime _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutedRegime {" +
				"regime=" + this.regime + ", " +
				"additionalRegime=" + this.additionalRegime + ", " +
				"regimeTerms=" + this.regimeTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of SubstitutedRegime  ***********************/
	class SubstitutedRegimeBuilderImpl implements SubstitutedRegime.SubstitutedRegimeBuilder {
	
		protected RegulatoryRegimeEnum regime;
		protected String additionalRegime;
		protected List<SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder> regimeTerms = new ArrayList<>();
		
		@Override
		@RosettaAttribute("regime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regime")
		public RegulatoryRegimeEnum getRegime() {
			return regime;
		}
		
		@Override
		@RosettaAttribute("additionalRegime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalRegime")
		public String getAdditionalRegime() {
			return additionalRegime;
		}
		
		@Override
		@RosettaAttribute("regimeTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("regimeTerms")
		public List<? extends SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder> getRegimeTerms() {
			return regimeTerms;
		}
		
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder getOrCreateRegimeTerms(int index) {
			if (regimeTerms==null) {
				this.regimeTerms = new ArrayList<>();
			}
			return getIndex(regimeTerms, index, () -> {
						SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder newRegimeTerms = SubstitutedRegimeTerms.builder();
						return newRegimeTerms;
					});
		}
		
		@RosettaAttribute("regime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regime")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder setRegime(RegulatoryRegimeEnum _regime) {
			this.regime = _regime == null ? null : _regime;
			return this;
		}
		
		@RosettaAttribute("additionalRegime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalRegime")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder setAdditionalRegime(String _additionalRegime) {
			this.additionalRegime = _additionalRegime == null ? null : _additionalRegime;
			return this;
		}
		
		@RosettaAttribute("regimeTerms")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("regimeTerms")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms _regimeTerms) {
			if (_regimeTerms != null) {
				this.regimeTerms.add(_regimeTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(SubstitutedRegimeTerms _regimeTerms, int idx) {
			getIndex(this.regimeTerms, idx, () -> _regimeTerms.toBuilder());
			return this;
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder addRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTermss) {
			if (regimeTermss != null) {
				for (final SubstitutedRegimeTerms toAdd : regimeTermss) {
					this.regimeTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("regimeTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("regimeTerms")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder setRegimeTerms(List<? extends SubstitutedRegimeTerms> regimeTermss) {
			if (regimeTermss == null) {
				this.regimeTerms = new ArrayList<>();
			} else {
				this.regimeTerms = regimeTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SubstitutedRegime build() {
			return new SubstitutedRegime.SubstitutedRegimeImpl(this);
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder prune() {
			regimeTerms = regimeTerms.stream().filter(b->b!=null).<SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRegime()!=null) return true;
			if (getAdditionalRegime()!=null) return true;
			if (getRegimeTerms()!=null && getRegimeTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SubstitutedRegime.SubstitutedRegimeBuilder o = (SubstitutedRegime.SubstitutedRegimeBuilder) other;
			
			merger.mergeRosetta(getRegimeTerms(), o.getRegimeTerms(), this::getOrCreateRegimeTerms);
			
			merger.mergeBasic(getRegime(), o.getRegime(), this::setRegime);
			merger.mergeBasic(getAdditionalRegime(), o.getAdditionalRegime(), this::setAdditionalRegime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegime _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutedRegimeBuilder {" +
				"regime=" + this.regime + ", " +
				"additionalRegime=" + this.additionalRegime + ", " +
				"regimeTerms=" + this.regimeTerms +
			'}';
		}
	}
}
