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
import iso20022.auth030.hkma.dtcc.meta.AssetClassCommodityFreight4ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is freight.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityFreight4Choice", builder=AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityFreight4Choice", model="iso20022", builder=AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityFreight4Choice extends RosettaModelObject {

	AssetClassCommodityFreight4ChoiceMeta metaData = new AssetClassCommodityFreight4ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Dry freight commodity derivative.
	 */
	FreightCommodityDry3 getDry();
	/**
	 * Wet freight commodity derivative.
	 */
	FreightCommodityWet3 getWet();
	/**
	 * Container ship freight commodity derivative.
	 */
	FreightCommodityContainerShip2 getCntnrShip();
	/**
	 * Other freight commodity derivative.
	 */
	FreightCommodityOther2 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityFreight4Choice build();
	
	AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder toBuilder();
	
	static AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder builder() {
		return new AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityFreight4Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityFreight4Choice> getType() {
		return AssetClassCommodityFreight4Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dry"), processor, FreightCommodityDry3.class, getDry());
		processRosetta(path.newSubPath("wet"), processor, FreightCommodityWet3.class, getWet());
		processRosetta(path.newSubPath("cntnrShip"), processor, FreightCommodityContainerShip2.class, getCntnrShip());
		processRosetta(path.newSubPath("othr"), processor, FreightCommodityOther2.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityFreight4ChoiceBuilder extends AssetClassCommodityFreight4Choice, RosettaModelObjectBuilder {
		FreightCommodityDry3.FreightCommodityDry3Builder getOrCreateDry();
		@Override
		FreightCommodityDry3.FreightCommodityDry3Builder getDry();
		FreightCommodityWet3.FreightCommodityWet3Builder getOrCreateWet();
		@Override
		FreightCommodityWet3.FreightCommodityWet3Builder getWet();
		FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder getOrCreateCntnrShip();
		@Override
		FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder getCntnrShip();
		FreightCommodityOther2.FreightCommodityOther2Builder getOrCreateOthr();
		@Override
		FreightCommodityOther2.FreightCommodityOther2Builder getOthr();
		AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setDry(FreightCommodityDry3 dry);
		AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setWet(FreightCommodityWet3 wet);
		AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setCntnrShip(FreightCommodityContainerShip2 cntnrShip);
		AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setOthr(FreightCommodityOther2 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dry"), processor, FreightCommodityDry3.FreightCommodityDry3Builder.class, getDry());
			processRosetta(path.newSubPath("wet"), processor, FreightCommodityWet3.FreightCommodityWet3Builder.class, getWet());
			processRosetta(path.newSubPath("cntnrShip"), processor, FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder.class, getCntnrShip());
			processRosetta(path.newSubPath("othr"), processor, FreightCommodityOther2.FreightCommodityOther2Builder.class, getOthr());
		}
		

		AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityFreight4Choice  ***********************/
	class AssetClassCommodityFreight4ChoiceImpl implements AssetClassCommodityFreight4Choice {
		private final FreightCommodityDry3 dry;
		private final FreightCommodityWet3 wet;
		private final FreightCommodityContainerShip2 cntnrShip;
		private final FreightCommodityOther2 othr;
		
		protected AssetClassCommodityFreight4ChoiceImpl(AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder builder) {
			this.dry = ofNullable(builder.getDry()).map(f->f.build()).orElse(null);
			this.wet = ofNullable(builder.getWet()).map(f->f.build()).orElse(null);
			this.cntnrShip = ofNullable(builder.getCntnrShip()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dry")
		public FreightCommodityDry3 getDry() {
			return dry;
		}
		
		@Override
		@RosettaAttribute("wet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wet")
		public FreightCommodityWet3 getWet() {
			return wet;
		}
		
		@Override
		@RosettaAttribute("cntnrShip")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntnrShip")
		public FreightCommodityContainerShip2 getCntnrShip() {
			return cntnrShip;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FreightCommodityOther2 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityFreight4Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder toBuilder() {
			AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder builder) {
			ofNullable(getDry()).ifPresent(builder::setDry);
			ofNullable(getWet()).ifPresent(builder::setWet);
			ofNullable(getCntnrShip()).ifPresent(builder::setCntnrShip);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityFreight4Choice _that = getType().cast(o);
		
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
			return "AssetClassCommodityFreight4Choice {" +
				"dry=" + this.dry + ", " +
				"wet=" + this.wet + ", " +
				"cntnrShip=" + this.cntnrShip + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityFreight4Choice  ***********************/
	class AssetClassCommodityFreight4ChoiceBuilderImpl implements AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder {
	
		protected FreightCommodityDry3.FreightCommodityDry3Builder dry;
		protected FreightCommodityWet3.FreightCommodityWet3Builder wet;
		protected FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder cntnrShip;
		protected FreightCommodityOther2.FreightCommodityOther2Builder othr;
		
		@Override
		@RosettaAttribute("dry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dry")
		public FreightCommodityDry3.FreightCommodityDry3Builder getDry() {
			return dry;
		}
		
		@Override
		public FreightCommodityDry3.FreightCommodityDry3Builder getOrCreateDry() {
			FreightCommodityDry3.FreightCommodityDry3Builder result;
			if (dry!=null) {
				result = dry;
			}
			else {
				result = dry = FreightCommodityDry3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("wet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("wet")
		public FreightCommodityWet3.FreightCommodityWet3Builder getWet() {
			return wet;
		}
		
		@Override
		public FreightCommodityWet3.FreightCommodityWet3Builder getOrCreateWet() {
			FreightCommodityWet3.FreightCommodityWet3Builder result;
			if (wet!=null) {
				result = wet;
			}
			else {
				result = wet = FreightCommodityWet3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cntnrShip")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntnrShip")
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder getCntnrShip() {
			return cntnrShip;
		}
		
		@Override
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder getOrCreateCntnrShip() {
			FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder result;
			if (cntnrShip!=null) {
				result = cntnrShip;
			}
			else {
				result = cntnrShip = FreightCommodityContainerShip2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FreightCommodityOther2.FreightCommodityOther2Builder getOthr() {
			return othr;
		}
		
		@Override
		public FreightCommodityOther2.FreightCommodityOther2Builder getOrCreateOthr() {
			FreightCommodityOther2.FreightCommodityOther2Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = FreightCommodityOther2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dry")
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setDry(FreightCommodityDry3 _dry) {
			this.dry = _dry == null ? null : _dry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("wet")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("wet")
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setWet(FreightCommodityWet3 _wet) {
			this.wet = _wet == null ? null : _wet.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cntnrShip")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cntnrShip")
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setCntnrShip(FreightCommodityContainerShip2 _cntnrShip) {
			this.cntnrShip = _cntnrShip == null ? null : _cntnrShip.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder setOthr(FreightCommodityOther2 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityFreight4Choice build() {
			return new AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder prune() {
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
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder o = (AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder) other;
			
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
		
			AssetClassCommodityFreight4Choice _that = getType().cast(o);
		
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
			return "AssetClassCommodityFreight4ChoiceBuilder {" +
				"dry=" + this.dry + ", " +
				"wet=" + this.wet + ", " +
				"cntnrShip=" + this.cntnrShip + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
