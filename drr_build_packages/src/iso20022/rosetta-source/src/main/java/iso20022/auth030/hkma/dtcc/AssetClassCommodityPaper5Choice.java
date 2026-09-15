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
import iso20022.auth030.hkma.dtcc.meta.AssetClassCommodityPaper5ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is paper.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityPaper5Choice", builder=AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityPaper5Choice", model="iso20022", builder=AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityPaper5Choice extends RosettaModelObject {

	AssetClassCommodityPaper5ChoiceMeta metaData = new AssetClassCommodityPaper5ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Container board commodity derivative.
	 */
	PaperCommodityContainerBoard2 getCntnrBrd();
	/**
	 * Newsprint commodity derivative.
	 */
	PaperCommodityNewsprint2 getNwsprnt();
	/**
	 * Pulp commodity derivative.
	 */
	PaperCommodityPulp2 getPulp();
	/**
	 * Recovered paper commodity derivative.
	 */
	PaperCommodityRecoveredPaper3 getRcvrdPpr();
	/**
	 * Other commodity derivative
	 */
	PaperCommodityOther1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityPaper5Choice build();
	
	AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder toBuilder();
	
	static AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder builder() {
		return new AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityPaper5Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityPaper5Choice> getType() {
		return AssetClassCommodityPaper5Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cntnrBrd"), processor, PaperCommodityContainerBoard2.class, getCntnrBrd());
		processRosetta(path.newSubPath("nwsprnt"), processor, PaperCommodityNewsprint2.class, getNwsprnt());
		processRosetta(path.newSubPath("pulp"), processor, PaperCommodityPulp2.class, getPulp());
		processRosetta(path.newSubPath("rcvrdPpr"), processor, PaperCommodityRecoveredPaper3.class, getRcvrdPpr());
		processRosetta(path.newSubPath("othr"), processor, PaperCommodityOther1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityPaper5ChoiceBuilder extends AssetClassCommodityPaper5Choice, RosettaModelObjectBuilder {
		PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder getOrCreateCntnrBrd();
		@Override
		PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder getCntnrBrd();
		PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder getOrCreateNwsprnt();
		@Override
		PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder getNwsprnt();
		PaperCommodityPulp2.PaperCommodityPulp2Builder getOrCreatePulp();
		@Override
		PaperCommodityPulp2.PaperCommodityPulp2Builder getPulp();
		PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder getOrCreateRcvrdPpr();
		@Override
		PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder getRcvrdPpr();
		PaperCommodityOther1.PaperCommodityOther1Builder getOrCreateOthr();
		@Override
		PaperCommodityOther1.PaperCommodityOther1Builder getOthr();
		AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setCntnrBrd(PaperCommodityContainerBoard2 cntnrBrd);
		AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setNwsprnt(PaperCommodityNewsprint2 nwsprnt);
		AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setPulp(PaperCommodityPulp2 pulp);
		AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setRcvrdPpr(PaperCommodityRecoveredPaper3 rcvrdPpr);
		AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setOthr(PaperCommodityOther1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cntnrBrd"), processor, PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder.class, getCntnrBrd());
			processRosetta(path.newSubPath("nwsprnt"), processor, PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder.class, getNwsprnt());
			processRosetta(path.newSubPath("pulp"), processor, PaperCommodityPulp2.PaperCommodityPulp2Builder.class, getPulp());
			processRosetta(path.newSubPath("rcvrdPpr"), processor, PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder.class, getRcvrdPpr());
			processRosetta(path.newSubPath("othr"), processor, PaperCommodityOther1.PaperCommodityOther1Builder.class, getOthr());
		}
		

		AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityPaper5Choice  ***********************/
	class AssetClassCommodityPaper5ChoiceImpl implements AssetClassCommodityPaper5Choice {
		private final PaperCommodityContainerBoard2 cntnrBrd;
		private final PaperCommodityNewsprint2 nwsprnt;
		private final PaperCommodityPulp2 pulp;
		private final PaperCommodityRecoveredPaper3 rcvrdPpr;
		private final PaperCommodityOther1 othr;
		
		protected AssetClassCommodityPaper5ChoiceImpl(AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder builder) {
			this.cntnrBrd = ofNullable(builder.getCntnrBrd()).map(f->f.build()).orElse(null);
			this.nwsprnt = ofNullable(builder.getNwsprnt()).map(f->f.build()).orElse(null);
			this.pulp = ofNullable(builder.getPulp()).map(f->f.build()).orElse(null);
			this.rcvrdPpr = ofNullable(builder.getRcvrdPpr()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cntnrBrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntnrBrd")
		public PaperCommodityContainerBoard2 getCntnrBrd() {
			return cntnrBrd;
		}
		
		@Override
		@RosettaAttribute("nwsprnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nwsprnt")
		public PaperCommodityNewsprint2 getNwsprnt() {
			return nwsprnt;
		}
		
		@Override
		@RosettaAttribute("pulp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pulp")
		public PaperCommodityPulp2 getPulp() {
			return pulp;
		}
		
		@Override
		@RosettaAttribute("rcvrdPpr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvrdPpr")
		public PaperCommodityRecoveredPaper3 getRcvrdPpr() {
			return rcvrdPpr;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PaperCommodityOther1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityPaper5Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder toBuilder() {
			AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder builder) {
			ofNullable(getCntnrBrd()).ifPresent(builder::setCntnrBrd);
			ofNullable(getNwsprnt()).ifPresent(builder::setNwsprnt);
			ofNullable(getPulp()).ifPresent(builder::setPulp);
			ofNullable(getRcvrdPpr()).ifPresent(builder::setRcvrdPpr);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityPaper5Choice _that = getType().cast(o);
		
			if (!Objects.equals(cntnrBrd, _that.getCntnrBrd())) return false;
			if (!Objects.equals(nwsprnt, _that.getNwsprnt())) return false;
			if (!Objects.equals(pulp, _that.getPulp())) return false;
			if (!Objects.equals(rcvrdPpr, _that.getRcvrdPpr())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cntnrBrd != null ? cntnrBrd.hashCode() : 0);
			_result = 31 * _result + (nwsprnt != null ? nwsprnt.hashCode() : 0);
			_result = 31 * _result + (pulp != null ? pulp.hashCode() : 0);
			_result = 31 * _result + (rcvrdPpr != null ? rcvrdPpr.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityPaper5Choice {" +
				"cntnrBrd=" + this.cntnrBrd + ", " +
				"nwsprnt=" + this.nwsprnt + ", " +
				"pulp=" + this.pulp + ", " +
				"rcvrdPpr=" + this.rcvrdPpr + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityPaper5Choice  ***********************/
	class AssetClassCommodityPaper5ChoiceBuilderImpl implements AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder {
	
		protected PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder cntnrBrd;
		protected PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder nwsprnt;
		protected PaperCommodityPulp2.PaperCommodityPulp2Builder pulp;
		protected PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder rcvrdPpr;
		protected PaperCommodityOther1.PaperCommodityOther1Builder othr;
		
		@Override
		@RosettaAttribute("cntnrBrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntnrBrd")
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder getCntnrBrd() {
			return cntnrBrd;
		}
		
		@Override
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder getOrCreateCntnrBrd() {
			PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder result;
			if (cntnrBrd!=null) {
				result = cntnrBrd;
			}
			else {
				result = cntnrBrd = PaperCommodityContainerBoard2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nwsprnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nwsprnt")
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder getNwsprnt() {
			return nwsprnt;
		}
		
		@Override
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder getOrCreateNwsprnt() {
			PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder result;
			if (nwsprnt!=null) {
				result = nwsprnt;
			}
			else {
				result = nwsprnt = PaperCommodityNewsprint2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pulp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pulp")
		public PaperCommodityPulp2.PaperCommodityPulp2Builder getPulp() {
			return pulp;
		}
		
		@Override
		public PaperCommodityPulp2.PaperCommodityPulp2Builder getOrCreatePulp() {
			PaperCommodityPulp2.PaperCommodityPulp2Builder result;
			if (pulp!=null) {
				result = pulp;
			}
			else {
				result = pulp = PaperCommodityPulp2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rcvrdPpr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvrdPpr")
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder getRcvrdPpr() {
			return rcvrdPpr;
		}
		
		@Override
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder getOrCreateRcvrdPpr() {
			PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder result;
			if (rcvrdPpr!=null) {
				result = rcvrdPpr;
			}
			else {
				result = rcvrdPpr = PaperCommodityRecoveredPaper3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PaperCommodityOther1.PaperCommodityOther1Builder getOthr() {
			return othr;
		}
		
		@Override
		public PaperCommodityOther1.PaperCommodityOther1Builder getOrCreateOthr() {
			PaperCommodityOther1.PaperCommodityOther1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = PaperCommodityOther1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cntnrBrd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cntnrBrd")
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setCntnrBrd(PaperCommodityContainerBoard2 _cntnrBrd) {
			this.cntnrBrd = _cntnrBrd == null ? null : _cntnrBrd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nwsprnt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nwsprnt")
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setNwsprnt(PaperCommodityNewsprint2 _nwsprnt) {
			this.nwsprnt = _nwsprnt == null ? null : _nwsprnt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pulp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pulp")
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setPulp(PaperCommodityPulp2 _pulp) {
			this.pulp = _pulp == null ? null : _pulp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rcvrdPpr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rcvrdPpr")
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setRcvrdPpr(PaperCommodityRecoveredPaper3 _rcvrdPpr) {
			this.rcvrdPpr = _rcvrdPpr == null ? null : _rcvrdPpr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder setOthr(PaperCommodityOther1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityPaper5Choice build() {
			return new AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder prune() {
			if (cntnrBrd!=null && !cntnrBrd.prune().hasData()) cntnrBrd = null;
			if (nwsprnt!=null && !nwsprnt.prune().hasData()) nwsprnt = null;
			if (pulp!=null && !pulp.prune().hasData()) pulp = null;
			if (rcvrdPpr!=null && !rcvrdPpr.prune().hasData()) rcvrdPpr = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCntnrBrd()!=null && getCntnrBrd().hasData()) return true;
			if (getNwsprnt()!=null && getNwsprnt().hasData()) return true;
			if (getPulp()!=null && getPulp().hasData()) return true;
			if (getRcvrdPpr()!=null && getRcvrdPpr().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder o = (AssetClassCommodityPaper5Choice.AssetClassCommodityPaper5ChoiceBuilder) other;
			
			merger.mergeRosetta(getCntnrBrd(), o.getCntnrBrd(), this::setCntnrBrd);
			merger.mergeRosetta(getNwsprnt(), o.getNwsprnt(), this::setNwsprnt);
			merger.mergeRosetta(getPulp(), o.getPulp(), this::setPulp);
			merger.mergeRosetta(getRcvrdPpr(), o.getRcvrdPpr(), this::setRcvrdPpr);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityPaper5Choice _that = getType().cast(o);
		
			if (!Objects.equals(cntnrBrd, _that.getCntnrBrd())) return false;
			if (!Objects.equals(nwsprnt, _that.getNwsprnt())) return false;
			if (!Objects.equals(pulp, _that.getPulp())) return false;
			if (!Objects.equals(rcvrdPpr, _that.getRcvrdPpr())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cntnrBrd != null ? cntnrBrd.hashCode() : 0);
			_result = 31 * _result + (nwsprnt != null ? nwsprnt.hashCode() : 0);
			_result = 31 * _result + (pulp != null ? pulp.hashCode() : 0);
			_result = 31 * _result + (rcvrdPpr != null ? rcvrdPpr.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityPaper5ChoiceBuilder {" +
				"cntnrBrd=" + this.cntnrBrd + ", " +
				"nwsprnt=" + this.nwsprnt + ", " +
				"pulp=" + this.pulp + ", " +
				"rcvrdPpr=" + this.rcvrdPpr + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
