package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.AssetClassCommodityEnvironmental3Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is environmental.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityEnvironmental3Choice__1", builder=AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityEnvironmental3Choice__1", model="iso20022", builder=AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityEnvironmental3Choice__1 extends RosettaModelObject {

	AssetClassCommodityEnvironmental3Choice__1Meta metaData = new AssetClassCommodityEnvironmental3Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Emissions environmental commodity derivative.
	 */
	EnvironmentalCommodityEmission3__1 getEmssns();
	/**
	 * Weather environmental commodity derivative.
	 */
	EnvironmentalCommodityWeather2__1 getWthr();
	/**
	 * Carbon related environmental commodity derivative.
	 */
	EnvironmentalCommodityCarbonRelated2__1 getCrbnRltd();
	/**
	 * Other environmental commodity derivative.
	 */
	EnvironmentCommodityOther2__1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityEnvironmental3Choice__1 build();
	
	AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder toBuilder();
	
	static AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder builder() {
		return new AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityEnvironmental3Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityEnvironmental3Choice__1> getType() {
		return AssetClassCommodityEnvironmental3Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("emssns"), processor, EnvironmentalCommodityEmission3__1.class, getEmssns());
		processRosetta(path.newSubPath("wthr"), processor, EnvironmentalCommodityWeather2__1.class, getWthr());
		processRosetta(path.newSubPath("crbnRltd"), processor, EnvironmentalCommodityCarbonRelated2__1.class, getCrbnRltd());
		processRosetta(path.newSubPath("othr"), processor, EnvironmentCommodityOther2__1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityEnvironmental3Choice__1Builder extends AssetClassCommodityEnvironmental3Choice__1, RosettaModelObjectBuilder {
		EnvironmentalCommodityEmission3__1.EnvironmentalCommodityEmission3__1Builder getOrCreateEmssns();
		@Override
		EnvironmentalCommodityEmission3__1.EnvironmentalCommodityEmission3__1Builder getEmssns();
		EnvironmentalCommodityWeather2__1.EnvironmentalCommodityWeather2__1Builder getOrCreateWthr();
		@Override
		EnvironmentalCommodityWeather2__1.EnvironmentalCommodityWeather2__1Builder getWthr();
		EnvironmentalCommodityCarbonRelated2__1.EnvironmentalCommodityCarbonRelated2__1Builder getOrCreateCrbnRltd();
		@Override
		EnvironmentalCommodityCarbonRelated2__1.EnvironmentalCommodityCarbonRelated2__1Builder getCrbnRltd();
		EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder getOrCreateOthr();
		@Override
		EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder getOthr();
		AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setEmssns(EnvironmentalCommodityEmission3__1 emssns);
		AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setWthr(EnvironmentalCommodityWeather2__1 wthr);
		AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setCrbnRltd(EnvironmentalCommodityCarbonRelated2__1 crbnRltd);
		AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setOthr(EnvironmentCommodityOther2__1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("emssns"), processor, EnvironmentalCommodityEmission3__1.EnvironmentalCommodityEmission3__1Builder.class, getEmssns());
			processRosetta(path.newSubPath("wthr"), processor, EnvironmentalCommodityWeather2__1.EnvironmentalCommodityWeather2__1Builder.class, getWthr());
			processRosetta(path.newSubPath("crbnRltd"), processor, EnvironmentalCommodityCarbonRelated2__1.EnvironmentalCommodityCarbonRelated2__1Builder.class, getCrbnRltd());
			processRosetta(path.newSubPath("othr"), processor, EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder.class, getOthr());
		}
		

		AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityEnvironmental3Choice__1  ***********************/
	class AssetClassCommodityEnvironmental3Choice__1Impl implements AssetClassCommodityEnvironmental3Choice__1 {
		private final EnvironmentalCommodityEmission3__1 emssns;
		private final EnvironmentalCommodityWeather2__1 wthr;
		private final EnvironmentalCommodityCarbonRelated2__1 crbnRltd;
		private final EnvironmentCommodityOther2__1 othr;
		
		protected AssetClassCommodityEnvironmental3Choice__1Impl(AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder builder) {
			this.emssns = ofNullable(builder.getEmssns()).map(f->f.build()).orElse(null);
			this.wthr = ofNullable(builder.getWthr()).map(f->f.build()).orElse(null);
			this.crbnRltd = ofNullable(builder.getCrbnRltd()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("emssns")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("emssns")
		public EnvironmentalCommodityEmission3__1 getEmssns() {
			return emssns;
		}
		
		@Override
		@RosettaAttribute("wthr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wthr")
		public EnvironmentalCommodityWeather2__1 getWthr() {
			return wthr;
		}
		
		@Override
		@RosettaAttribute("crbnRltd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crbnRltd")
		public EnvironmentalCommodityCarbonRelated2__1 getCrbnRltd() {
			return crbnRltd;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnvironmentCommodityOther2__1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder toBuilder() {
			AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder builder) {
			ofNullable(getEmssns()).ifPresent(builder::setEmssns);
			ofNullable(getWthr()).ifPresent(builder::setWthr);
			ofNullable(getCrbnRltd()).ifPresent(builder::setCrbnRltd);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityEnvironmental3Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityEnvironmental3Choice__1 {" +
				"emssns=" + this.emssns + ", " +
				"wthr=" + this.wthr + ", " +
				"crbnRltd=" + this.crbnRltd + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityEnvironmental3Choice__1  ***********************/
	class AssetClassCommodityEnvironmental3Choice__1BuilderImpl implements AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder {
	
		protected EnvironmentalCommodityEmission3__1.EnvironmentalCommodityEmission3__1Builder emssns;
		protected EnvironmentalCommodityWeather2__1.EnvironmentalCommodityWeather2__1Builder wthr;
		protected EnvironmentalCommodityCarbonRelated2__1.EnvironmentalCommodityCarbonRelated2__1Builder crbnRltd;
		protected EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder othr;
		
		@Override
		@RosettaAttribute("emssns")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("emssns")
		public EnvironmentalCommodityEmission3__1.EnvironmentalCommodityEmission3__1Builder getEmssns() {
			return emssns;
		}
		
		@Override
		public EnvironmentalCommodityEmission3__1.EnvironmentalCommodityEmission3__1Builder getOrCreateEmssns() {
			EnvironmentalCommodityEmission3__1.EnvironmentalCommodityEmission3__1Builder result;
			if (emssns!=null) {
				result = emssns;
			}
			else {
				result = emssns = EnvironmentalCommodityEmission3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("wthr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wthr")
		public EnvironmentalCommodityWeather2__1.EnvironmentalCommodityWeather2__1Builder getWthr() {
			return wthr;
		}
		
		@Override
		public EnvironmentalCommodityWeather2__1.EnvironmentalCommodityWeather2__1Builder getOrCreateWthr() {
			EnvironmentalCommodityWeather2__1.EnvironmentalCommodityWeather2__1Builder result;
			if (wthr!=null) {
				result = wthr;
			}
			else {
				result = wthr = EnvironmentalCommodityWeather2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crbnRltd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crbnRltd")
		public EnvironmentalCommodityCarbonRelated2__1.EnvironmentalCommodityCarbonRelated2__1Builder getCrbnRltd() {
			return crbnRltd;
		}
		
		@Override
		public EnvironmentalCommodityCarbonRelated2__1.EnvironmentalCommodityCarbonRelated2__1Builder getOrCreateCrbnRltd() {
			EnvironmentalCommodityCarbonRelated2__1.EnvironmentalCommodityCarbonRelated2__1Builder result;
			if (crbnRltd!=null) {
				result = crbnRltd;
			}
			else {
				result = crbnRltd = EnvironmentalCommodityCarbonRelated2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder getOthr() {
			return othr;
		}
		
		@Override
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder getOrCreateOthr() {
			EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = EnvironmentCommodityOther2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("emssns")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("emssns")
		@Override
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setEmssns(EnvironmentalCommodityEmission3__1 _emssns) {
			this.emssns = _emssns == null ? null : _emssns.toBuilder();
			return this;
		}
		
		@RosettaAttribute("wthr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("wthr")
		@Override
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setWthr(EnvironmentalCommodityWeather2__1 _wthr) {
			this.wthr = _wthr == null ? null : _wthr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crbnRltd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("crbnRltd")
		@Override
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setCrbnRltd(EnvironmentalCommodityCarbonRelated2__1 _crbnRltd) {
			this.crbnRltd = _crbnRltd == null ? null : _crbnRltd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder setOthr(EnvironmentCommodityOther2__1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice__1 build() {
			return new AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder prune() {
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
		public AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder o = (AssetClassCommodityEnvironmental3Choice__1.AssetClassCommodityEnvironmental3Choice__1Builder) other;
			
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
		
			AssetClassCommodityEnvironmental3Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityEnvironmental3Choice__1Builder {" +
				"emssns=" + this.emssns + ", " +
				"wthr=" + this.wthr + ", " +
				"crbnRltd=" + this.crbnRltd + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
