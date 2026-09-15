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
import iso20022.auth030.fca.meta.AssetClassCommodityPaper4Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is paper.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityPaper4Choice__1", builder=AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityPaper4Choice__1", model="iso20022", builder=AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityPaper4Choice__1 extends RosettaModelObject {

	AssetClassCommodityPaper4Choice__1Meta metaData = new AssetClassCommodityPaper4Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Container board commodity derivative.
	 */
	PaperCommodityContainerBoard2__1 getCntnrBrd();
	/**
	 * Newsprint commodity derivative.
	 */
	PaperCommodityNewsprint2__1 getNwsprnt();
	/**
	 * Pulp commodity derivative.
	 */
	PaperCommodityPulp2__1 getPulp();
	/**
	 * Recovered paper commodity derivative.
	 */
	PaperCommodityOther1__1 getRcvrdPpr();
	/**
	 * Other commodity derivative
	 */
	PaperCommodityOther1__1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityPaper4Choice__1 build();
	
	AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder toBuilder();
	
	static AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder builder() {
		return new AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityPaper4Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityPaper4Choice__1> getType() {
		return AssetClassCommodityPaper4Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cntnrBrd"), processor, PaperCommodityContainerBoard2__1.class, getCntnrBrd());
		processRosetta(path.newSubPath("nwsprnt"), processor, PaperCommodityNewsprint2__1.class, getNwsprnt());
		processRosetta(path.newSubPath("pulp"), processor, PaperCommodityPulp2__1.class, getPulp());
		processRosetta(path.newSubPath("rcvrdPpr"), processor, PaperCommodityOther1__1.class, getRcvrdPpr());
		processRosetta(path.newSubPath("othr"), processor, PaperCommodityOther1__1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityPaper4Choice__1Builder extends AssetClassCommodityPaper4Choice__1, RosettaModelObjectBuilder {
		PaperCommodityContainerBoard2__1.PaperCommodityContainerBoard2__1Builder getOrCreateCntnrBrd();
		@Override
		PaperCommodityContainerBoard2__1.PaperCommodityContainerBoard2__1Builder getCntnrBrd();
		PaperCommodityNewsprint2__1.PaperCommodityNewsprint2__1Builder getOrCreateNwsprnt();
		@Override
		PaperCommodityNewsprint2__1.PaperCommodityNewsprint2__1Builder getNwsprnt();
		PaperCommodityPulp2__1.PaperCommodityPulp2__1Builder getOrCreatePulp();
		@Override
		PaperCommodityPulp2__1.PaperCommodityPulp2__1Builder getPulp();
		PaperCommodityOther1__1.PaperCommodityOther1__1Builder getOrCreateRcvrdPpr();
		@Override
		PaperCommodityOther1__1.PaperCommodityOther1__1Builder getRcvrdPpr();
		PaperCommodityOther1__1.PaperCommodityOther1__1Builder getOrCreateOthr();
		@Override
		PaperCommodityOther1__1.PaperCommodityOther1__1Builder getOthr();
		AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setCntnrBrd(PaperCommodityContainerBoard2__1 cntnrBrd);
		AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setNwsprnt(PaperCommodityNewsprint2__1 nwsprnt);
		AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setPulp(PaperCommodityPulp2__1 pulp);
		AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setRcvrdPpr(PaperCommodityOther1__1 rcvrdPpr);
		AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setOthr(PaperCommodityOther1__1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cntnrBrd"), processor, PaperCommodityContainerBoard2__1.PaperCommodityContainerBoard2__1Builder.class, getCntnrBrd());
			processRosetta(path.newSubPath("nwsprnt"), processor, PaperCommodityNewsprint2__1.PaperCommodityNewsprint2__1Builder.class, getNwsprnt());
			processRosetta(path.newSubPath("pulp"), processor, PaperCommodityPulp2__1.PaperCommodityPulp2__1Builder.class, getPulp());
			processRosetta(path.newSubPath("rcvrdPpr"), processor, PaperCommodityOther1__1.PaperCommodityOther1__1Builder.class, getRcvrdPpr());
			processRosetta(path.newSubPath("othr"), processor, PaperCommodityOther1__1.PaperCommodityOther1__1Builder.class, getOthr());
		}
		

		AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityPaper4Choice__1  ***********************/
	class AssetClassCommodityPaper4Choice__1Impl implements AssetClassCommodityPaper4Choice__1 {
		private final PaperCommodityContainerBoard2__1 cntnrBrd;
		private final PaperCommodityNewsprint2__1 nwsprnt;
		private final PaperCommodityPulp2__1 pulp;
		private final PaperCommodityOther1__1 rcvrdPpr;
		private final PaperCommodityOther1__1 othr;
		
		protected AssetClassCommodityPaper4Choice__1Impl(AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder builder) {
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
		public PaperCommodityContainerBoard2__1 getCntnrBrd() {
			return cntnrBrd;
		}
		
		@Override
		@RosettaAttribute("nwsprnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nwsprnt")
		public PaperCommodityNewsprint2__1 getNwsprnt() {
			return nwsprnt;
		}
		
		@Override
		@RosettaAttribute("pulp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pulp")
		public PaperCommodityPulp2__1 getPulp() {
			return pulp;
		}
		
		@Override
		@RosettaAttribute("rcvrdPpr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvrdPpr")
		public PaperCommodityOther1__1 getRcvrdPpr() {
			return rcvrdPpr;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PaperCommodityOther1__1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityPaper4Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder toBuilder() {
			AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder builder) {
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
		
			AssetClassCommodityPaper4Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityPaper4Choice__1 {" +
				"cntnrBrd=" + this.cntnrBrd + ", " +
				"nwsprnt=" + this.nwsprnt + ", " +
				"pulp=" + this.pulp + ", " +
				"rcvrdPpr=" + this.rcvrdPpr + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityPaper4Choice__1  ***********************/
	class AssetClassCommodityPaper4Choice__1BuilderImpl implements AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder {
	
		protected PaperCommodityContainerBoard2__1.PaperCommodityContainerBoard2__1Builder cntnrBrd;
		protected PaperCommodityNewsprint2__1.PaperCommodityNewsprint2__1Builder nwsprnt;
		protected PaperCommodityPulp2__1.PaperCommodityPulp2__1Builder pulp;
		protected PaperCommodityOther1__1.PaperCommodityOther1__1Builder rcvrdPpr;
		protected PaperCommodityOther1__1.PaperCommodityOther1__1Builder othr;
		
		@Override
		@RosettaAttribute("cntnrBrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntnrBrd")
		public PaperCommodityContainerBoard2__1.PaperCommodityContainerBoard2__1Builder getCntnrBrd() {
			return cntnrBrd;
		}
		
		@Override
		public PaperCommodityContainerBoard2__1.PaperCommodityContainerBoard2__1Builder getOrCreateCntnrBrd() {
			PaperCommodityContainerBoard2__1.PaperCommodityContainerBoard2__1Builder result;
			if (cntnrBrd!=null) {
				result = cntnrBrd;
			}
			else {
				result = cntnrBrd = PaperCommodityContainerBoard2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nwsprnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nwsprnt")
		public PaperCommodityNewsprint2__1.PaperCommodityNewsprint2__1Builder getNwsprnt() {
			return nwsprnt;
		}
		
		@Override
		public PaperCommodityNewsprint2__1.PaperCommodityNewsprint2__1Builder getOrCreateNwsprnt() {
			PaperCommodityNewsprint2__1.PaperCommodityNewsprint2__1Builder result;
			if (nwsprnt!=null) {
				result = nwsprnt;
			}
			else {
				result = nwsprnt = PaperCommodityNewsprint2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pulp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pulp")
		public PaperCommodityPulp2__1.PaperCommodityPulp2__1Builder getPulp() {
			return pulp;
		}
		
		@Override
		public PaperCommodityPulp2__1.PaperCommodityPulp2__1Builder getOrCreatePulp() {
			PaperCommodityPulp2__1.PaperCommodityPulp2__1Builder result;
			if (pulp!=null) {
				result = pulp;
			}
			else {
				result = pulp = PaperCommodityPulp2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rcvrdPpr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvrdPpr")
		public PaperCommodityOther1__1.PaperCommodityOther1__1Builder getRcvrdPpr() {
			return rcvrdPpr;
		}
		
		@Override
		public PaperCommodityOther1__1.PaperCommodityOther1__1Builder getOrCreateRcvrdPpr() {
			PaperCommodityOther1__1.PaperCommodityOther1__1Builder result;
			if (rcvrdPpr!=null) {
				result = rcvrdPpr;
			}
			else {
				result = rcvrdPpr = PaperCommodityOther1__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PaperCommodityOther1__1.PaperCommodityOther1__1Builder getOthr() {
			return othr;
		}
		
		@Override
		public PaperCommodityOther1__1.PaperCommodityOther1__1Builder getOrCreateOthr() {
			PaperCommodityOther1__1.PaperCommodityOther1__1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = PaperCommodityOther1__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cntnrBrd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cntnrBrd")
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setCntnrBrd(PaperCommodityContainerBoard2__1 _cntnrBrd) {
			this.cntnrBrd = _cntnrBrd == null ? null : _cntnrBrd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nwsprnt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nwsprnt")
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setNwsprnt(PaperCommodityNewsprint2__1 _nwsprnt) {
			this.nwsprnt = _nwsprnt == null ? null : _nwsprnt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pulp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pulp")
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setPulp(PaperCommodityPulp2__1 _pulp) {
			this.pulp = _pulp == null ? null : _pulp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rcvrdPpr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rcvrdPpr")
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setRcvrdPpr(PaperCommodityOther1__1 _rcvrdPpr) {
			this.rcvrdPpr = _rcvrdPpr == null ? null : _rcvrdPpr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder setOthr(PaperCommodityOther1__1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityPaper4Choice__1 build() {
			return new AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder prune() {
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
		public AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder o = (AssetClassCommodityPaper4Choice__1.AssetClassCommodityPaper4Choice__1Builder) other;
			
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
		
			AssetClassCommodityPaper4Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityPaper4Choice__1Builder {" +
				"cntnrBrd=" + this.cntnrBrd + ", " +
				"nwsprnt=" + this.nwsprnt + ", " +
				"pulp=" + this.pulp + ", " +
				"rcvrdPpr=" + this.rcvrdPpr + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
