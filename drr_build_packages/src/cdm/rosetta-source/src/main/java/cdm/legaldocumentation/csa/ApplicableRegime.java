package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ApplicableRegimeMeta;
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
 * A class to specify the applicable regulatory regime(s) that parties to a legal agreement, such as the ISDA 2016 and 2018 CSA for Initial Margin, might be subject to.
 * @version 6.23.0
 */
@RosettaDataType(value="ApplicableRegime", builder=ApplicableRegime.ApplicableRegimeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ApplicableRegime", model="cdm", builder=ApplicableRegime.ApplicableRegimeBuilderImpl.class, version="6.23.0")
public interface ApplicableRegime extends RosettaModelObject {

	ApplicableRegimeMeta metaData = new ApplicableRegimeMeta();

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
	 * A class that is used by the ApplicableRegime and the AdditionalRegime classes to specify the terms that are specific to each party and regime which are referred to in the Regime Table as part of certain legal agreements, such as the ISDA 2016 and 2018 CSA for Initial Margin.
	 */
	List<? extends RegimeTerms> getRegimeTerms();
	/**
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(b)(B)"
	 *
	 * Provision 
	 *
	 */
	AdditionalTypeEnum getAdditionalType();
	/**
	 * The bespoke Additional Type for the purposes of Covered Transactions (IM).
	 */
	String getAdditionalTerms();

	/*********************** Build Methods  ***********************/
	ApplicableRegime build();
	
	ApplicableRegime.ApplicableRegimeBuilder toBuilder();
	
	static ApplicableRegime.ApplicableRegimeBuilder builder() {
		return new ApplicableRegime.ApplicableRegimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableRegime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableRegime> getType() {
		return ApplicableRegime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
		processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
		processRosetta(path.newSubPath("regimeTerms"), processor, RegimeTerms.class, getRegimeTerms());
		processor.processBasic(path.newSubPath("additionalType"), AdditionalTypeEnum.class, getAdditionalType(), this);
		processor.processBasic(path.newSubPath("additionalTerms"), String.class, getAdditionalTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableRegimeBuilder extends ApplicableRegime, RosettaModelObjectBuilder {
		RegimeTerms.RegimeTermsBuilder getOrCreateRegimeTerms(int index);
		@Override
		List<? extends RegimeTerms.RegimeTermsBuilder> getRegimeTerms();
		ApplicableRegime.ApplicableRegimeBuilder setRegime(RegulatoryRegimeEnum regime);
		ApplicableRegime.ApplicableRegimeBuilder setAdditionalRegime(String additionalRegime);
		ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms regimeTerms);
		ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms regimeTerms, int idx);
		ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(List<? extends RegimeTerms> regimeTerms);
		ApplicableRegime.ApplicableRegimeBuilder setRegimeTerms(List<? extends RegimeTerms> regimeTerms);
		ApplicableRegime.ApplicableRegimeBuilder setAdditionalType(AdditionalTypeEnum additionalType);
		ApplicableRegime.ApplicableRegimeBuilder setAdditionalTerms(String additionalTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("regime"), RegulatoryRegimeEnum.class, getRegime(), this);
			processor.processBasic(path.newSubPath("additionalRegime"), String.class, getAdditionalRegime(), this);
			processRosetta(path.newSubPath("regimeTerms"), processor, RegimeTerms.RegimeTermsBuilder.class, getRegimeTerms());
			processor.processBasic(path.newSubPath("additionalType"), AdditionalTypeEnum.class, getAdditionalType(), this);
			processor.processBasic(path.newSubPath("additionalTerms"), String.class, getAdditionalTerms(), this);
		}
		

		ApplicableRegime.ApplicableRegimeBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableRegime  ***********************/
	class ApplicableRegimeImpl implements ApplicableRegime {
		private final RegulatoryRegimeEnum regime;
		private final String additionalRegime;
		private final List<? extends RegimeTerms> regimeTerms;
		private final AdditionalTypeEnum additionalType;
		private final String additionalTerms;
		
		protected ApplicableRegimeImpl(ApplicableRegime.ApplicableRegimeBuilder builder) {
			this.regime = builder.getRegime();
			this.additionalRegime = builder.getAdditionalRegime();
			this.regimeTerms = ofNullable(builder.getRegimeTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalType = builder.getAdditionalType();
			this.additionalTerms = builder.getAdditionalTerms();
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
		public List<? extends RegimeTerms> getRegimeTerms() {
			return regimeTerms;
		}
		
		@Override
		@RosettaAttribute("additionalType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalType")
		public AdditionalTypeEnum getAdditionalType() {
			return additionalType;
		}
		
		@Override
		@RosettaAttribute("additionalTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalTerms")
		public String getAdditionalTerms() {
			return additionalTerms;
		}
		
		@Override
		public ApplicableRegime build() {
			return this;
		}
		
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder toBuilder() {
			ApplicableRegime.ApplicableRegimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableRegime.ApplicableRegimeBuilder builder) {
			ofNullable(getRegime()).ifPresent(builder::setRegime);
			ofNullable(getAdditionalRegime()).ifPresent(builder::setAdditionalRegime);
			ofNullable(getRegimeTerms()).ifPresent(builder::setRegimeTerms);
			ofNullable(getAdditionalType()).ifPresent(builder::setAdditionalType);
			ofNullable(getAdditionalTerms()).ifPresent(builder::setAdditionalTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableRegime _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			if (!Objects.equals(additionalType, _that.getAdditionalType())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			_result = 31 * _result + (additionalType != null ? additionalType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableRegime {" +
				"regime=" + this.regime + ", " +
				"additionalRegime=" + this.additionalRegime + ", " +
				"regimeTerms=" + this.regimeTerms + ", " +
				"additionalType=" + this.additionalType + ", " +
				"additionalTerms=" + this.additionalTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicableRegime  ***********************/
	class ApplicableRegimeBuilderImpl implements ApplicableRegime.ApplicableRegimeBuilder {
	
		protected RegulatoryRegimeEnum regime;
		protected String additionalRegime;
		protected List<RegimeTerms.RegimeTermsBuilder> regimeTerms = new ArrayList<>();
		protected AdditionalTypeEnum additionalType;
		protected String additionalTerms;
		
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
		public List<? extends RegimeTerms.RegimeTermsBuilder> getRegimeTerms() {
			return regimeTerms;
		}
		
		@Override
		public RegimeTerms.RegimeTermsBuilder getOrCreateRegimeTerms(int index) {
			if (regimeTerms==null) {
				this.regimeTerms = new ArrayList<>();
			}
			return getIndex(regimeTerms, index, () -> {
						RegimeTerms.RegimeTermsBuilder newRegimeTerms = RegimeTerms.builder();
						return newRegimeTerms;
					});
		}
		
		@Override
		@RosettaAttribute("additionalType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalType")
		public AdditionalTypeEnum getAdditionalType() {
			return additionalType;
		}
		
		@Override
		@RosettaAttribute("additionalTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalTerms")
		public String getAdditionalTerms() {
			return additionalTerms;
		}
		
		@RosettaAttribute("regime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regime")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setRegime(RegulatoryRegimeEnum _regime) {
			this.regime = _regime == null ? null : _regime;
			return this;
		}
		
		@RosettaAttribute("additionalRegime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalRegime")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setAdditionalRegime(String _additionalRegime) {
			this.additionalRegime = _additionalRegime == null ? null : _additionalRegime;
			return this;
		}
		
		@RosettaAttribute("regimeTerms")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("regimeTerms")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms _regimeTerms) {
			if (_regimeTerms != null) {
				this.regimeTerms.add(_regimeTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(RegimeTerms _regimeTerms, int idx) {
			getIndex(this.regimeTerms, idx, () -> _regimeTerms.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder addRegimeTerms(List<? extends RegimeTerms> regimeTermss) {
			if (regimeTermss != null) {
				for (final RegimeTerms toAdd : regimeTermss) {
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
		public ApplicableRegime.ApplicableRegimeBuilder setRegimeTerms(List<? extends RegimeTerms> regimeTermss) {
			if (regimeTermss == null) {
				this.regimeTerms = new ArrayList<>();
			} else {
				this.regimeTerms = regimeTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalType")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setAdditionalType(AdditionalTypeEnum _additionalType) {
			this.additionalType = _additionalType == null ? null : _additionalType;
			return this;
		}
		
		@RosettaAttribute("additionalTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalTerms")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder setAdditionalTerms(String _additionalTerms) {
			this.additionalTerms = _additionalTerms == null ? null : _additionalTerms;
			return this;
		}
		
		@Override
		public ApplicableRegime build() {
			return new ApplicableRegime.ApplicableRegimeImpl(this);
		}
		
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder prune() {
			regimeTerms = regimeTerms.stream().filter(b->b!=null).<RegimeTerms.RegimeTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRegime()!=null) return true;
			if (getAdditionalRegime()!=null) return true;
			if (getRegimeTerms()!=null && getRegimeTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalType()!=null) return true;
			if (getAdditionalTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableRegime.ApplicableRegimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableRegime.ApplicableRegimeBuilder o = (ApplicableRegime.ApplicableRegimeBuilder) other;
			
			merger.mergeRosetta(getRegimeTerms(), o.getRegimeTerms(), this::getOrCreateRegimeTerms);
			
			merger.mergeBasic(getRegime(), o.getRegime(), this::setRegime);
			merger.mergeBasic(getAdditionalRegime(), o.getAdditionalRegime(), this::setAdditionalRegime);
			merger.mergeBasic(getAdditionalType(), o.getAdditionalType(), this::setAdditionalType);
			merger.mergeBasic(getAdditionalTerms(), o.getAdditionalTerms(), this::setAdditionalTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableRegime _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(additionalRegime, _that.getAdditionalRegime())) return false;
			if (!ListEquals.listEquals(regimeTerms, _that.getRegimeTerms())) return false;
			if (!Objects.equals(additionalType, _that.getAdditionalType())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regime != null ? regime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalRegime != null ? additionalRegime.hashCode() : 0);
			_result = 31 * _result + (regimeTerms != null ? regimeTerms.hashCode() : 0);
			_result = 31 * _result + (additionalType != null ? additionalType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableRegimeBuilder {" +
				"regime=" + this.regime + ", " +
				"additionalRegime=" + this.additionalRegime + ", " +
				"regimeTerms=" + this.regimeTerms + ", " +
				"additionalType=" + this.additionalType + ", " +
				"additionalTerms=" + this.additionalTerms +
			'}';
		}
	}
}
