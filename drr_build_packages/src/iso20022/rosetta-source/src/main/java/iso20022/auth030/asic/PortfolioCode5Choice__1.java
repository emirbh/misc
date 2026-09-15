package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.PortfolioCode5Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioCode5Choice__1", builder=PortfolioCode5Choice__1.PortfolioCode5Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PortfolioCode5Choice__1", model="iso20022", builder=PortfolioCode5Choice__1.PortfolioCode5Choice__1BuilderImpl.class, version="${project.version}")
public interface PortfolioCode5Choice__1 extends RosettaModelObject {

	PortfolioCode5Choice__1Meta metaData = new PortfolioCode5Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	PortfolioIdentification3__1 getPrtfl();
	NotApplicable1Code getNoPrtfl();

	/*********************** Build Methods  ***********************/
	PortfolioCode5Choice__1 build();
	
	PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder toBuilder();
	
	static PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder builder() {
		return new PortfolioCode5Choice__1.PortfolioCode5Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioCode5Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioCode5Choice__1> getType() {
		return PortfolioCode5Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("prtfl"), processor, PortfolioIdentification3__1.class, getPrtfl());
		processor.processBasic(path.newSubPath("noPrtfl"), NotApplicable1Code.class, getNoPrtfl(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioCode5Choice__1Builder extends PortfolioCode5Choice__1, RosettaModelObjectBuilder {
		PortfolioIdentification3__1.PortfolioIdentification3__1Builder getOrCreatePrtfl();
		@Override
		PortfolioIdentification3__1.PortfolioIdentification3__1Builder getPrtfl();
		PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder setPrtfl(PortfolioIdentification3__1 prtfl);
		PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder setNoPrtfl(NotApplicable1Code noPrtfl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("prtfl"), processor, PortfolioIdentification3__1.PortfolioIdentification3__1Builder.class, getPrtfl());
			processor.processBasic(path.newSubPath("noPrtfl"), NotApplicable1Code.class, getNoPrtfl(), this);
		}
		

		PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of PortfolioCode5Choice__1  ***********************/
	class PortfolioCode5Choice__1Impl implements PortfolioCode5Choice__1 {
		private final PortfolioIdentification3__1 prtfl;
		private final NotApplicable1Code noPrtfl;
		
		protected PortfolioCode5Choice__1Impl(PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder builder) {
			this.prtfl = ofNullable(builder.getPrtfl()).map(f->f.build()).orElse(null);
			this.noPrtfl = builder.getNoPrtfl();
		}
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtfl")
		public PortfolioIdentification3__1 getPrtfl() {
			return prtfl;
		}
		
		@Override
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noPrtfl")
		public NotApplicable1Code getNoPrtfl() {
			return noPrtfl;
		}
		
		@Override
		public PortfolioCode5Choice__1 build() {
			return this;
		}
		
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder toBuilder() {
			PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder builder) {
			ofNullable(getPrtfl()).ifPresent(builder::setPrtfl);
			ofNullable(getNoPrtfl()).ifPresent(builder::setNoPrtfl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioCode5Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			if (!Objects.equals(noPrtfl, _that.getNoPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			_result = 31 * _result + (noPrtfl != null ? noPrtfl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioCode5Choice__1 {" +
				"prtfl=" + this.prtfl + ", " +
				"noPrtfl=" + this.noPrtfl +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioCode5Choice__1  ***********************/
	class PortfolioCode5Choice__1BuilderImpl implements PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder {
	
		protected PortfolioIdentification3__1.PortfolioIdentification3__1Builder prtfl;
		protected NotApplicable1Code noPrtfl;
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtfl")
		public PortfolioIdentification3__1.PortfolioIdentification3__1Builder getPrtfl() {
			return prtfl;
		}
		
		@Override
		public PortfolioIdentification3__1.PortfolioIdentification3__1Builder getOrCreatePrtfl() {
			PortfolioIdentification3__1.PortfolioIdentification3__1Builder result;
			if (prtfl!=null) {
				result = prtfl;
			}
			else {
				result = prtfl = PortfolioIdentification3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noPrtfl")
		public NotApplicable1Code getNoPrtfl() {
			return noPrtfl;
		}
		
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtfl")
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder setPrtfl(PortfolioIdentification3__1 _prtfl) {
			this.prtfl = _prtfl == null ? null : _prtfl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noPrtfl")
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder setNoPrtfl(NotApplicable1Code _noPrtfl) {
			this.noPrtfl = _noPrtfl == null ? null : _noPrtfl;
			return this;
		}
		
		@Override
		public PortfolioCode5Choice__1 build() {
			return new PortfolioCode5Choice__1.PortfolioCode5Choice__1Impl(this);
		}
		
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder prune() {
			if (prtfl!=null && !prtfl.prune().hasData()) prtfl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrtfl()!=null && getPrtfl().hasData()) return true;
			if (getNoPrtfl()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder o = (PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder) other;
			
			merger.mergeRosetta(getPrtfl(), o.getPrtfl(), this::setPrtfl);
			
			merger.mergeBasic(getNoPrtfl(), o.getNoPrtfl(), this::setNoPrtfl);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioCode5Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			if (!Objects.equals(noPrtfl, _that.getNoPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			_result = 31 * _result + (noPrtfl != null ? noPrtfl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioCode5Choice__1Builder {" +
				"prtfl=" + this.prtfl + ", " +
				"noPrtfl=" + this.noPrtfl +
			'}';
		}
	}
}
