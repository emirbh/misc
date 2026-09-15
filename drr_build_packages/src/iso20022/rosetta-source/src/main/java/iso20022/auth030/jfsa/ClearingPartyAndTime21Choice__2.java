package iso20022.auth030.jfsa;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth030.jfsa.meta.ClearingPartyAndTime21Choice__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingPartyAndTime21Choice__2", builder=ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingPartyAndTime21Choice__2", model="iso20022", builder=ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2BuilderImpl.class, version="${project.version}")
public interface ClearingPartyAndTime21Choice__2 extends RosettaModelObject {

	ClearingPartyAndTime21Choice__2Meta metaData = new ClearingPartyAndTime21Choice__2Meta();

	/*********************** Getter Methods  ***********************/
	ClearingPartyAndTime22__2 getDtls();

	/*********************** Build Methods  ***********************/
	ClearingPartyAndTime21Choice__2 build();
	
	ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder toBuilder();
	
	static ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder builder() {
		return new ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingPartyAndTime21Choice__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingPartyAndTime21Choice__2> getType() {
		return ClearingPartyAndTime21Choice__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dtls"), processor, ClearingPartyAndTime22__2.class, getDtls());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingPartyAndTime21Choice__2Builder extends ClearingPartyAndTime21Choice__2, RosettaModelObjectBuilder {
		ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder getOrCreateDtls();
		@Override
		ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder getDtls();
		ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder setDtls(ClearingPartyAndTime22__2 dtls);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dtls"), processor, ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder.class, getDtls());
		}
		

		ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder prune();
	}

	/*********************** Immutable Implementation of ClearingPartyAndTime21Choice__2  ***********************/
	class ClearingPartyAndTime21Choice__2Impl implements ClearingPartyAndTime21Choice__2 {
		private final ClearingPartyAndTime22__2 dtls;
		
		protected ClearingPartyAndTime21Choice__2Impl(ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder builder) {
			this.dtls = ofNullable(builder.getDtls()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtls")
		public ClearingPartyAndTime22__2 getDtls() {
			return dtls;
		}
		
		@Override
		public ClearingPartyAndTime21Choice__2 build() {
			return this;
		}
		
		@Override
		public ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder toBuilder() {
			ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder builder) {
			ofNullable(getDtls()).ifPresent(builder::setDtls);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime21Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(dtls, _that.getDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dtls != null ? dtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime21Choice__2 {" +
				"dtls=" + this.dtls +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingPartyAndTime21Choice__2  ***********************/
	class ClearingPartyAndTime21Choice__2BuilderImpl implements ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder {
	
		protected ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder dtls;
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtls")
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder getDtls() {
			return dtls;
		}
		
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder getOrCreateDtls() {
			ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder result;
			if (dtls!=null) {
				result = dtls;
			}
			else {
				result = dtls = ClearingPartyAndTime22__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dtls")
		@Override
		public ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder setDtls(ClearingPartyAndTime22__2 _dtls) {
			this.dtls = _dtls == null ? null : _dtls.toBuilder();
			return this;
		}
		
		@Override
		public ClearingPartyAndTime21Choice__2 build() {
			return new ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Impl(this);
		}
		
		@Override
		public ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder prune() {
			if (dtls!=null && !dtls.prune().hasData()) dtls = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDtls()!=null && getDtls().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder o = (ClearingPartyAndTime21Choice__2.ClearingPartyAndTime21Choice__2Builder) other;
			
			merger.mergeRosetta(getDtls(), o.getDtls(), this::setDtls);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime21Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(dtls, _that.getDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dtls != null ? dtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime21Choice__2Builder {" +
				"dtls=" + this.dtls +
			'}';
		}
	}
}
