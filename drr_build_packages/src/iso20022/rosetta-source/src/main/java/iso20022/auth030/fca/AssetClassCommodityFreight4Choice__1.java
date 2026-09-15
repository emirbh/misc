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
import iso20022.auth030.fca.meta.AssetClassCommodityFreight4Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is freight.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityFreight4Choice__1", builder=AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityFreight4Choice__1", model="iso20022", builder=AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityFreight4Choice__1 extends RosettaModelObject {

	AssetClassCommodityFreight4Choice__1Meta metaData = new AssetClassCommodityFreight4Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Dry freight commodity derivative.
	 */
	FreightCommodityDry3__1 getDry();
	/**
	 * Wet freight commodity derivative.
	 */
	FreightCommodityWet3__1 getWet();
	/**
	 * Container ship freight commodity derivative.
	 */
	FreightCommodityContainerShip2__1 getCntnrShip();
	/**
	 * Other freight commodity derivative.
	 */
	FreightCommodityOther2__1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityFreight4Choice__1 build();
	
	AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder toBuilder();
	
	static AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder builder() {
		return new AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityFreight4Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityFreight4Choice__1> getType() {
		return AssetClassCommodityFreight4Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dry"), processor, FreightCommodityDry3__1.class, getDry());
		processRosetta(path.newSubPath("wet"), processor, FreightCommodityWet3__1.class, getWet());
		processRosetta(path.newSubPath("cntnrShip"), processor, FreightCommodityContainerShip2__1.class, getCntnrShip());
		processRosetta(path.newSubPath("othr"), processor, FreightCommodityOther2__1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityFreight4Choice__1Builder extends AssetClassCommodityFreight4Choice__1, RosettaModelObjectBuilder {
		FreightCommodityDry3__1.FreightCommodityDry3__1Builder getOrCreateDry();
		@Override
		FreightCommodityDry3__1.FreightCommodityDry3__1Builder getDry();
		FreightCommodityWet3__1.FreightCommodityWet3__1Builder getOrCreateWet();
		@Override
		FreightCommodityWet3__1.FreightCommodityWet3__1Builder getWet();
		FreightCommodityContainerShip2__1.FreightCommodityContainerShip2__1Builder getOrCreateCntnrShip();
		@Override
		FreightCommodityContainerShip2__1.FreightCommodityContainerShip2__1Builder getCntnrShip();
		FreightCommodityOther2__1.FreightCommodityOther2__1Builder getOrCreateOthr();
		@Override
		FreightCommodityOther2__1.FreightCommodityOther2__1Builder getOthr();
		AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setDry(FreightCommodityDry3__1 dry);
		AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setWet(FreightCommodityWet3__1 wet);
		AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setCntnrShip(FreightCommodityContainerShip2__1 cntnrShip);
		AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setOthr(FreightCommodityOther2__1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dry"), processor, FreightCommodityDry3__1.FreightCommodityDry3__1Builder.class, getDry());
			processRosetta(path.newSubPath("wet"), processor, FreightCommodityWet3__1.FreightCommodityWet3__1Builder.class, getWet());
			processRosetta(path.newSubPath("cntnrShip"), processor, FreightCommodityContainerShip2__1.FreightCommodityContainerShip2__1Builder.class, getCntnrShip());
			processRosetta(path.newSubPath("othr"), processor, FreightCommodityOther2__1.FreightCommodityOther2__1Builder.class, getOthr());
		}
		

		AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityFreight4Choice__1  ***********************/
	class AssetClassCommodityFreight4Choice__1Impl implements AssetClassCommodityFreight4Choice__1 {
		private final FreightCommodityDry3__1 dry;
		private final FreightCommodityWet3__1 wet;
		private final FreightCommodityContainerShip2__1 cntnrShip;
		private final FreightCommodityOther2__1 othr;
		
		protected AssetClassCommodityFreight4Choice__1Impl(AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder builder) {
			this.dry = ofNullable(builder.getDry()).map(f->f.build()).orElse(null);
			this.wet = ofNullable(builder.getWet()).map(f->f.build()).orElse(null);
			this.cntnrShip = ofNullable(builder.getCntnrShip()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dry")
		public FreightCommodityDry3__1 getDry() {
			return dry;
		}
		
		@Override
		@RosettaAttribute("wet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wet")
		public FreightCommodityWet3__1 getWet() {
			return wet;
		}
		
		@Override
		@RosettaAttribute("cntnrShip")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntnrShip")
		public FreightCommodityContainerShip2__1 getCntnrShip() {
			return cntnrShip;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FreightCommodityOther2__1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityFreight4Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder toBuilder() {
			AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder builder) {
			ofNullable(getDry()).ifPresent(builder::setDry);
			ofNullable(getWet()).ifPresent(builder::setWet);
			ofNullable(getCntnrShip()).ifPresent(builder::setCntnrShip);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityFreight4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dry, _that.getDry())) return false;
			if (!Objects.equals(wet, _that.getWet())) return false;
			if (!Objects.equals(cntnrShip, _that.getCntnrShip())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dry != null ? dry.hashCode() : 0);
			_result = 31 * _result + (wet != null ? wet.hashCode() : 0);
			_result = 31 * _result + (cntnrShip != null ? cntnrShip.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityFreight4Choice__1 {" +
				"dry=" + this.dry + ", " +
				"wet=" + this.wet + ", " +
				"cntnrShip=" + this.cntnrShip + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityFreight4Choice__1  ***********************/
	class AssetClassCommodityFreight4Choice__1BuilderImpl implements AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder {
	
		protected FreightCommodityDry3__1.FreightCommodityDry3__1Builder dry;
		protected FreightCommodityWet3__1.FreightCommodityWet3__1Builder wet;
		protected FreightCommodityContainerShip2__1.FreightCommodityContainerShip2__1Builder cntnrShip;
		protected FreightCommodityOther2__1.FreightCommodityOther2__1Builder othr;
		
		@Override
		@RosettaAttribute("dry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dry")
		public FreightCommodityDry3__1.FreightCommodityDry3__1Builder getDry() {
			return dry;
		}
		
		@Override
		public FreightCommodityDry3__1.FreightCommodityDry3__1Builder getOrCreateDry() {
			FreightCommodityDry3__1.FreightCommodityDry3__1Builder result;
			if (dry!=null) {
				result = dry;
			}
			else {
				result = dry = FreightCommodityDry3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("wet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wet")
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder getWet() {
			return wet;
		}
		
		@Override
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder getOrCreateWet() {
			FreightCommodityWet3__1.FreightCommodityWet3__1Builder result;
			if (wet!=null) {
				result = wet;
			}
			else {
				result = wet = FreightCommodityWet3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cntnrShip")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntnrShip")
		public FreightCommodityContainerShip2__1.FreightCommodityContainerShip2__1Builder getCntnrShip() {
			return cntnrShip;
		}
		
		@Override
		public FreightCommodityContainerShip2__1.FreightCommodityContainerShip2__1Builder getOrCreateCntnrShip() {
			FreightCommodityContainerShip2__1.FreightCommodityContainerShip2__1Builder result;
			if (cntnrShip!=null) {
				result = cntnrShip;
			}
			else {
				result = cntnrShip = FreightCommodityContainerShip2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FreightCommodityOther2__1.FreightCommodityOther2__1Builder getOthr() {
			return othr;
		}
		
		@Override
		public FreightCommodityOther2__1.FreightCommodityOther2__1Builder getOrCreateOthr() {
			FreightCommodityOther2__1.FreightCommodityOther2__1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = FreightCommodityOther2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dry")
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setDry(FreightCommodityDry3__1 _dry) {
			this.dry = _dry == null ? null : _dry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("wet")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("wet")
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setWet(FreightCommodityWet3__1 _wet) {
			this.wet = _wet == null ? null : _wet.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cntnrShip")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cntnrShip")
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setCntnrShip(FreightCommodityContainerShip2__1 _cntnrShip) {
			this.cntnrShip = _cntnrShip == null ? null : _cntnrShip.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder setOthr(FreightCommodityOther2__1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityFreight4Choice__1 build() {
			return new AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder prune() {
			if (dry!=null && !dry.prune().hasData()) dry = null;
			if (wet!=null && !wet.prune().hasData()) wet = null;
			if (cntnrShip!=null && !cntnrShip.prune().hasData()) cntnrShip = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDry()!=null && getDry().hasData()) return true;
			if (getWet()!=null && getWet().hasData()) return true;
			if (getCntnrShip()!=null && getCntnrShip().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder o = (AssetClassCommodityFreight4Choice__1.AssetClassCommodityFreight4Choice__1Builder) other;
			
			merger.mergeRosetta(getDry(), o.getDry(), this::setDry);
			merger.mergeRosetta(getWet(), o.getWet(), this::setWet);
			merger.mergeRosetta(getCntnrShip(), o.getCntnrShip(), this::setCntnrShip);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityFreight4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dry, _that.getDry())) return false;
			if (!Objects.equals(wet, _that.getWet())) return false;
			if (!Objects.equals(cntnrShip, _that.getCntnrShip())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dry != null ? dry.hashCode() : 0);
			_result = 31 * _result + (wet != null ? wet.hashCode() : 0);
			_result = 31 * _result + (cntnrShip != null ? cntnrShip.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityFreight4Choice__1Builder {" +
				"dry=" + this.dry + ", " +
				"wet=" + this.wet + ", " +
				"cntnrShip=" + this.cntnrShip + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
