package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.Package4__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Package4__1", builder=Package4__1.Package4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Package4__1", model="iso20022", builder=Package4__1.Package4__1BuilderImpl.class, version="${project.version}")
public interface Package4__1 extends RosettaModelObject {

	Package4__1Meta metaData = new Package4__1Meta();

	/*********************** Getter Methods  ***********************/
	String getCmplxTradId();
	String getFxSwpLkId();

	/*********************** Build Methods  ***********************/
	Package4__1 build();
	
	Package4__1.Package4__1Builder toBuilder();
	
	static Package4__1.Package4__1Builder builder() {
		return new Package4__1.Package4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Package4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Package4__1> getType() {
		return Package4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cmplxTradId"), String.class, getCmplxTradId(), this);
		processor.processBasic(path.newSubPath("fxSwpLkId"), String.class, getFxSwpLkId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Package4__1Builder extends Package4__1, RosettaModelObjectBuilder {
		Package4__1.Package4__1Builder setCmplxTradId(String cmplxTradId);
		Package4__1.Package4__1Builder setFxSwpLkId(String fxSwpLkId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cmplxTradId"), String.class, getCmplxTradId(), this);
			processor.processBasic(path.newSubPath("fxSwpLkId"), String.class, getFxSwpLkId(), this);
		}
		

		Package4__1.Package4__1Builder prune();
	}

	/*********************** Immutable Implementation of Package4__1  ***********************/
	class Package4__1Impl implements Package4__1 {
		private final String cmplxTradId;
		private final String fxSwpLkId;
		
		protected Package4__1Impl(Package4__1.Package4__1Builder builder) {
			this.cmplxTradId = builder.getCmplxTradId();
			this.fxSwpLkId = builder.getFxSwpLkId();
		}
		
		@Override
		@RosettaAttribute("cmplxTradId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cmplxTradId")
		public String getCmplxTradId() {
			return cmplxTradId;
		}
		
		@Override
		@RosettaAttribute("fxSwpLkId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxSwpLkId")
		public String getFxSwpLkId() {
			return fxSwpLkId;
		}
		
		@Override
		public Package4__1 build() {
			return this;
		}
		
		@Override
		public Package4__1.Package4__1Builder toBuilder() {
			Package4__1.Package4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Package4__1.Package4__1Builder builder) {
			ofNullable(getCmplxTradId()).ifPresent(builder::setCmplxTradId);
			ofNullable(getFxSwpLkId()).ifPresent(builder::setFxSwpLkId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Package4__1 _that = getType().cast(o);
		
			if (!Objects.equals(cmplxTradId, _that.getCmplxTradId())) return false;
			if (!Objects.equals(fxSwpLkId, _that.getFxSwpLkId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cmplxTradId != null ? cmplxTradId.hashCode() : 0);
			_result = 31 * _result + (fxSwpLkId != null ? fxSwpLkId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Package4__1 {" +
				"cmplxTradId=" + this.cmplxTradId + ", " +
				"fxSwpLkId=" + this.fxSwpLkId +
			'}';
		}
	}

	/*********************** Builder Implementation of Package4__1  ***********************/
	class Package4__1BuilderImpl implements Package4__1.Package4__1Builder {
	
		protected String cmplxTradId;
		protected String fxSwpLkId;
		
		@Override
		@RosettaAttribute("cmplxTradId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cmplxTradId")
		public String getCmplxTradId() {
			return cmplxTradId;
		}
		
		@Override
		@RosettaAttribute("fxSwpLkId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxSwpLkId")
		public String getFxSwpLkId() {
			return fxSwpLkId;
		}
		
		@RosettaAttribute("cmplxTradId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cmplxTradId")
		@Override
		public Package4__1.Package4__1Builder setCmplxTradId(String _cmplxTradId) {
			this.cmplxTradId = _cmplxTradId == null ? null : _cmplxTradId;
			return this;
		}
		
		@RosettaAttribute("fxSwpLkId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxSwpLkId")
		@Override
		public Package4__1.Package4__1Builder setFxSwpLkId(String _fxSwpLkId) {
			this.fxSwpLkId = _fxSwpLkId == null ? null : _fxSwpLkId;
			return this;
		}
		
		@Override
		public Package4__1 build() {
			return new Package4__1.Package4__1Impl(this);
		}
		
		@Override
		public Package4__1.Package4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Package4__1.Package4__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCmplxTradId()!=null) return true;
			if (getFxSwpLkId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Package4__1.Package4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Package4__1.Package4__1Builder o = (Package4__1.Package4__1Builder) other;
			
			
			merger.mergeBasic(getCmplxTradId(), o.getCmplxTradId(), this::setCmplxTradId);
			merger.mergeBasic(getFxSwpLkId(), o.getFxSwpLkId(), this::setFxSwpLkId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Package4__1 _that = getType().cast(o);
		
			if (!Objects.equals(cmplxTradId, _that.getCmplxTradId())) return false;
			if (!Objects.equals(fxSwpLkId, _that.getFxSwpLkId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cmplxTradId != null ? cmplxTradId.hashCode() : 0);
			_result = 31 * _result + (fxSwpLkId != null ? fxSwpLkId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Package4__1Builder {" +
				"cmplxTradId=" + this.cmplxTradId + ", " +
				"fxSwpLkId=" + this.fxSwpLkId +
			'}';
		}
	}
}
