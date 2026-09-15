package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.hkma.dtcc.meta.AssetClassCommodityEnvironmental3ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is environmental.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityEnvironmental3Choice", builder=AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityEnvironmental3Choice", model="iso20022", builder=AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityEnvironmental3Choice extends RosettaModelObject {

	AssetClassCommodityEnvironmental3ChoiceMeta metaData = new AssetClassCommodityEnvironmental3ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Emissions environmental commodity derivative.
	 */
	EnvironmentalCommodityEmission3 getEmssns();
	/**
	 * Weather environmental commodity derivative.
	 */
	EnvironmentalCommodityWeather2 getWthr();
	/**
	 * Carbon related environmental commodity derivative.
	 */
	EnvironmentalCommodityCarbonRelated2 getCrbnRltd();
	/**
	 * Other environmental commodity derivative.
	 */
	EnvironmentCommodityOther2 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityEnvironmental3Choice build();
	
	AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder toBuilder();
	
	static AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder builder() {
		return new AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityEnvironmental3Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityEnvironmental3Choice> getType() {
		return AssetClassCommodityEnvironmental3Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("emssns"), processor, EnvironmentalCommodityEmission3.class, getEmssns());
		processRosetta(path.newSubPath("wthr"), processor, EnvironmentalCommodityWeather2.class, getWthr());
		processRosetta(path.newSubPath("crbnRltd"), processor, EnvironmentalCommodityCarbonRelated2.class, getCrbnRltd());
		processRosetta(path.newSubPath("othr"), processor, EnvironmentCommodityOther2.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityEnvironmental3ChoiceBuilder extends AssetClassCommodityEnvironmental3Choice, RosettaModelObjectBuilder {
		EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder getOrCreateEmssns();
		@Override
		EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder getEmssns();
		EnvironmentalCommodityWeather2.EnvironmentalCommodityWeather2Builder getOrCreateWthr();
		@Override
		EnvironmentalCommodityWeather2.EnvironmentalCommodityWeather2Builder getWthr();
		EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder getOrCreateCrbnRltd();
		@Override
		EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder getCrbnRltd();
		EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder getOrCreateOthr();
		@Override
		EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder getOthr();
		AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setEmssns(EnvironmentalCommodityEmission3 emssns);
		AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setWthr(EnvironmentalCommodityWeather2 wthr);
		AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setCrbnRltd(EnvironmentalCommodityCarbonRelated2 crbnRltd);
		AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setOthr(EnvironmentCommodityOther2 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("emssns"), processor, EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder.class, getEmssns());
			processRosetta(path.newSubPath("wthr"), processor, EnvironmentalCommodityWeather2.EnvironmentalCommodityWeather2Builder.class, getWthr());
			processRosetta(path.newSubPath("crbnRltd"), processor, EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder.class, getCrbnRltd());
			processRosetta(path.newSubPath("othr"), processor, EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder.class, getOthr());
		}
		

		AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityEnvironmental3Choice  ***********************/
	class AssetClassCommodityEnvironmental3ChoiceImpl implements AssetClassCommodityEnvironmental3Choice {
		private final EnvironmentalCommodityEmission3 emssns;
		private final EnvironmentalCommodityWeather2 wthr;
		private final EnvironmentalCommodityCarbonRelated2 crbnRltd;
		private final EnvironmentCommodityOther2 othr;
		
		protected AssetClassCommodityEnvironmental3ChoiceImpl(AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder builder) {
			this.emssns = ofNullable(builder.getEmssns()).map(f->f.build()).orElse(null);
			this.wthr = ofNullable(builder.getWthr()).map(f->f.build()).orElse(null);
			this.crbnRltd = ofNullable(builder.getCrbnRltd()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("emssns")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("emssns")
		public EnvironmentalCommodityEmission3 getEmssns() {
			return emssns;
		}
		
		@Override
		@RosettaAttribute("wthr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wthr")
		public EnvironmentalCommodityWeather2 getWthr() {
			return wthr;
		}
		
		@Override
		@RosettaAttribute("crbnRltd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crbnRltd")
		public EnvironmentalCommodityCarbonRelated2 getCrbnRltd() {
			return crbnRltd;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnvironmentCommodityOther2 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder toBuilder() {
			AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder builder) {
			ofNullable(getEmssns()).ifPresent(builder::setEmssns);
			ofNullable(getWthr()).ifPresent(builder::setWthr);
			ofNullable(getCrbnRltd()).ifPresent(builder::setCrbnRltd);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityEnvironmental3Choice _that = getType().cast(o);
		
			if (!Objects.equals(emssns, _that.getEmssns())) return false;
			if (!Objects.equals(wthr, _that.getWthr())) return false;
			if (!Objects.equals(crbnRltd, _that.getCrbnRltd())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (emssns != null ? emssns.hashCode() : 0);
			_result = 31 * _result + (wthr != null ? wthr.hashCode() : 0);
			_result = 31 * _result + (crbnRltd != null ? crbnRltd.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityEnvironmental3Choice {" +
				"emssns=" + this.emssns + ", " +
				"wthr=" + this.wthr + ", " +
				"crbnRltd=" + this.crbnRltd + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityEnvironmental3Choice  ***********************/
	class AssetClassCommodityEnvironmental3ChoiceBuilderImpl implements AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder {
	
		protected EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder emssns;
		protected EnvironmentalCommodityWeather2.EnvironmentalCommodityWeather2Builder wthr;
		protected EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder crbnRltd;
		protected EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder othr;
		
		@Override
		@RosettaAttribute("emssns")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("emssns")
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder getEmssns() {
			return emssns;
		}
		
		@Override
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder getOrCreateEmssns() {
			EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder result;
			if (emssns!=null) {
				result = emssns;
			}
			else {
				result = emssns = EnvironmentalCommodityEmission3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("wthr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wthr")
		public EnvironmentalCommodityWeather2.EnvironmentalCommodityWeather2Builder getWthr() {
			return wthr;
		}
		
		@Override
		public EnvironmentalCommodityWeather2.EnvironmentalCommodityWeather2Builder getOrCreateWthr() {
			EnvironmentalCommodityWeather2.EnvironmentalCommodityWeather2Builder result;
			if (wthr!=null) {
				result = wthr;
			}
			else {
				result = wthr = EnvironmentalCommodityWeather2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crbnRltd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crbnRltd")
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder getCrbnRltd() {
			return crbnRltd;
		}
		
		@Override
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder getOrCreateCrbnRltd() {
			EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder result;
			if (crbnRltd!=null) {
				result = crbnRltd;
			}
			else {
				result = crbnRltd = EnvironmentalCommodityCarbonRelated2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder getOthr() {
			return othr;
		}
		
		@Override
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder getOrCreateOthr() {
			EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = EnvironmentCommodityOther2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("emssns")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("emssns")
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setEmssns(EnvironmentalCommodityEmission3 _emssns) {
			this.emssns = _emssns == null ? null : _emssns.toBuilder();
			return this;
		}
		
		@RosettaAttribute("wthr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("wthr")
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setWthr(EnvironmentalCommodityWeather2 _wthr) {
			this.wthr = _wthr == null ? null : _wthr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crbnRltd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("crbnRltd")
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setCrbnRltd(EnvironmentalCommodityCarbonRelated2 _crbnRltd) {
			this.crbnRltd = _crbnRltd == null ? null : _crbnRltd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder setOthr(EnvironmentCommodityOther2 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice build() {
			return new AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder prune() {
			if (emssns!=null && !emssns.prune().hasData()) emssns = null;
			if (wthr!=null && !wthr.prune().hasData()) wthr = null;
			if (crbnRltd!=null && !crbnRltd.prune().hasData()) crbnRltd = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEmssns()!=null && getEmssns().hasData()) return true;
			if (getWthr()!=null && getWthr().hasData()) return true;
			if (getCrbnRltd()!=null && getCrbnRltd().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder o = (AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder) other;
			
			merger.mergeRosetta(getEmssns(), o.getEmssns(), this::setEmssns);
			merger.mergeRosetta(getWthr(), o.getWthr(), this::setWthr);
			merger.mergeRosetta(getCrbnRltd(), o.getCrbnRltd(), this::setCrbnRltd);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityEnvironmental3Choice _that = getType().cast(o);
		
			if (!Objects.equals(emssns, _that.getEmssns())) return false;
			if (!Objects.equals(wthr, _that.getWthr())) return false;
			if (!Objects.equals(crbnRltd, _that.getCrbnRltd())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (emssns != null ? emssns.hashCode() : 0);
			_result = 31 * _result + (wthr != null ? wthr.hashCode() : 0);
			_result = 31 * _result + (crbnRltd != null ? crbnRltd.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityEnvironmental3ChoiceBuilder {" +
				"emssns=" + this.emssns + ", " +
				"wthr=" + this.wthr + ", " +
				"crbnRltd=" + this.crbnRltd + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
