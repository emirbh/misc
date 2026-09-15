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
import iso20022.auth030.jfsa.meta.ClearingPartyAndTime22Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingPartyAndTime22Choice__1", builder=ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingPartyAndTime22Choice__1", model="iso20022", builder=ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1BuilderImpl.class, version="${project.version}")
public interface ClearingPartyAndTime22Choice__1 extends RosettaModelObject {

	ClearingPartyAndTime22Choice__1Meta metaData = new ClearingPartyAndTime22Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	ClearingPartyAndTime23__1 getDtls();

	/*********************** Build Methods  ***********************/
	ClearingPartyAndTime22Choice__1 build();
	
	ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder toBuilder();
	
	static ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder builder() {
		return new ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingPartyAndTime22Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingPartyAndTime22Choice__1> getType() {
		return ClearingPartyAndTime22Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dtls"), processor, ClearingPartyAndTime23__1.class, getDtls());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingPartyAndTime22Choice__1Builder extends ClearingPartyAndTime22Choice__1, RosettaModelObjectBuilder {
		ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder getOrCreateDtls();
		@Override
		ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder getDtls();
		ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder setDtls(ClearingPartyAndTime23__1 dtls);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dtls"), processor, ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder.class, getDtls());
		}
		

		ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of ClearingPartyAndTime22Choice__1  ***********************/
	class ClearingPartyAndTime22Choice__1Impl implements ClearingPartyAndTime22Choice__1 {
		private final ClearingPartyAndTime23__1 dtls;
		
		protected ClearingPartyAndTime22Choice__1Impl(ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder builder) {
			this.dtls = ofNullable(builder.getDtls()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtls")
		public ClearingPartyAndTime23__1 getDtls() {
			return dtls;
		}
		
		@Override
		public ClearingPartyAndTime22Choice__1 build() {
			return this;
		}
		
		@Override
		public ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder toBuilder() {
			ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder builder) {
			ofNullable(getDtls()).ifPresent(builder::setDtls);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22Choice__1 _that = getType().cast(o);
		
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
			return "ClearingPartyAndTime22Choice__1 {" +
				"dtls=" + this.dtls +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingPartyAndTime22Choice__1  ***********************/
	class ClearingPartyAndTime22Choice__1BuilderImpl implements ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder {
	
		protected ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder dtls;
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtls")
		public ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder getDtls() {
			return dtls;
		}
		
		@Override
		public ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder getOrCreateDtls() {
			ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder result;
			if (dtls!=null) {
				result = dtls;
			}
			else {
				result = dtls = ClearingPartyAndTime23__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dtls")
		@Override
		public ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder setDtls(ClearingPartyAndTime23__1 _dtls) {
			this.dtls = _dtls == null ? null : _dtls.toBuilder();
			return this;
		}
		
		@Override
		public ClearingPartyAndTime22Choice__1 build() {
			return new ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Impl(this);
		}
		
		@Override
		public ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder prune() {
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
		public ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder o = (ClearingPartyAndTime22Choice__1.ClearingPartyAndTime22Choice__1Builder) other;
			
			merger.mergeRosetta(getDtls(), o.getDtls(), this::setDtls);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22Choice__1 _that = getType().cast(o);
		
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
			return "ClearingPartyAndTime22Choice__1Builder {" +
				"dtls=" + this.dtls +
			'}';
		}
	}
}
